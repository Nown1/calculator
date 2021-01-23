package com.nown.utils.calculator;

import com.nown.utils.CharStack;
import com.nown.utils.DoubleStack;

public class SimpleCalculator {
    private CharStack charStack;//字符栈，存放运算符
    private DoubleStack doubleStack;//数栈，存放运算符
    private String question;//数学表达式
    int length;

    public SimpleCalculator(String question) {
        this.question = question;
        length = question.length();
        charStack = new CharStack(length);
        doubleStack = new DoubleStack(length);
        charStack.add('#');//先在操作符栈存放一个#代表最低优先级运算符
        doubleStack.add(0.0);//在数栈存放0进行初始化，防止"0.5"用".5"表示时报错
    }

    public String getAnswer() {
        int i = 0;
        String number = "0";//临时存放数字，到运算符时则意味着这个数字结束，编程double值存到数栈
        boolean notComplete;//判断有没有将操作符压入栈内
        try {
            for (;i<length;i++){
                char ch = question.charAt(i);
                notComplete=true;//没有完成进栈操作？yes

                    if (ch == '(') {
                        //如果是左括号直接进栈即可
                        charStack.add(ch);
                        notComplete = false;
                    } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == ')') {
                        //如果是操作符或右括号
                        //先把number记录的数字压入数字栈，然后把number="0"进行初始化
                        double num = Double.parseDouble(number);
                        number = "0";
                        doubleStack.add(num);

                        while (notComplete) {
                            if (icp(ch) > isp(charStack.pop())) {
                                //如果要进栈的操作符优先级高
                                //则将数字进栈，运算符进栈
                                charStack.add(ch);
                                notComplete = false;//没有完成压栈操作？no，完成了
                            } else if (icp(ch) < isp(charStack.pop())) {
                                //如果要进栈操作符优先级低，则从栈中取出一个操作符和两个操作数进行计算
                                //将结果压入数字栈，然后接着判断（不需要让notComplete=false），直到该操作符进栈
                                char operator = charStack.remove();
                                double num1 = doubleStack.remove();
                                double num2 = doubleStack.remove();
                                double result = calculate(num2, num1, operator);
                                doubleStack.add(result);
                            } else {
                                //当要进栈的操作符优先级和栈顶元素优先级相等，
                                //则只可能是栈顶元素是左括号，要进栈元素是右括号
                                if (i == length - 1) {
                                    //如果此时右括号刚好是表达式最后一个字符，则只要将左括号移除
                                    charStack.remove();
                                    notComplete=false;
                                } else {
                                    //如果不是在表达式末尾，需要提前对右括号后面的操作符进行处理，
                                    //然后i++跳过后面的操作符
                                    //这样做的目的是防止后面的操作符使数字栈多存入一个0
                                    charStack.remove();
                                    char operator = question.charAt(++i);
                                    boolean flag = true;//设置一个临时变量判断有没有将右括号后面的操作符入栈

                                    while (flag) {
                                        if (icp(operator) > isp(charStack.pop())) {
                                            //如果该操作符优先级比较高，则直接入栈即可，操作结束
                                            charStack.add(operator);
                                            flag = false;
                                        } else {
                                            //如果该操作符优先级比较低，则取出一个操作符，两个操作数进行运算，
                                            //然后接着判断（先不让flag=false），直到该操作符进栈
                                            char op=charStack.remove();
                                            double num1 = doubleStack.remove();
                                            double num2 = doubleStack.remove();
                                            double result = calculate(num2, num1, op);
                                            doubleStack.add(result);

                                        }
                                    }
                                    notComplete=false;
                                }
                            }
                        }

                    } else {
                        number += ch;
                    }

            }
        //整个算式已经遍历完，但是最后一个数字可能还没进栈，且字符栈内可能还有运算符，也就是说还没有运算结束
        //如果最后一个字符是右括号，那么所有的数字都已经进栈了，
            // 不需要把最后的number="0"压入栈内，否则需要压入栈内
            if(question.charAt(length-1)!=')'){
                System.out.println("遍历后将数字"+Double.parseDouble(number)+"压入栈内");
                doubleStack.add(Double.parseDouble(number));
            }
            System.out.println("完成遍历");

        while (!charStack.isEmpty()) {
            char operator = charStack.remove();
            double num1 = doubleStack.remove();
            double num2 = doubleStack.remove();
            double result=calculate(num2,num1,operator);
            doubleStack.add(result);
        }
    }catch( Exception e){
        return "错误";
    }

    double answer = doubleStack.remove();
        return""+answer;
}

    public double calculate(double num2,double num1,char operator) throws Exception{
        switch (operator){
            case '+':
                System.out.println("执行了一次加法："+num2+"+"+num1);
                return num2+num1;
            case '-':
                System.out.println("执行了一次减法："+num2+"-"+num1);
                return num2-num1;
            case '*':
                System.out.println("执行了一次乘法："+num2+"*"+num1);
                return num2*num1;
            default:
                if (num1==0){
                    throw new Exception();
                }
                System.out.println("执行了一次除法："+num2+"/"+num1);
                return num2/num1;
        }

    }

    public int isp(char ch) {//判断站内操作符优先级
        switch (ch) {
            case '#':
                return 0;
            case '(':
                return 1;
            case '*':
            case '/':
                return 5;
            case '+':
            case '-':
                return 3;
            default:
                return -1;
        }
    }

    public int icp(char ch) {//判断要进站操作符优先级
        switch (ch) {
            case '#':
                return 0;
            case '(':
                return 6;
            case '*':
            case '/':
            case '%':
                return 4;
            case '+':
            case '-':
                return 2;
            case ')':
                return 1;
            default:
                return -1;
        }
    }
}
