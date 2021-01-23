package com.nown.utils;

public class CharStack {
    private int top;
    private char[] elements;
    public CharStack(int size){
        top=-1;
        elements=new char[size];
    }
    public char remove(){//退栈方法，从栈中取出栈顶元素并移除
        System.out.println("将第"+top+"个运算符"+elements[top]+"移除运算符栈");
        return elements[top--];
    }
    public char pop(){//显示栈顶元素，只显示而不移除
        return elements[top];
    }
    public void add(char value){
        System.out.println("第"+(top+1)+"个入栈的运算符是"+value);
        elements[++top]=value;
    }
    public boolean isEmpty(){
        return top==0;
    }
}
