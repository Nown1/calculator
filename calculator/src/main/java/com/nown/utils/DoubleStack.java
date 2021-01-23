package com.nown.utils;

public class DoubleStack {
    private int top;
    private double[] elements;
    public DoubleStack(int size){
        top=-1;
        elements=new double[size];
    }
    public double remove(){
        System.out.println("将第"+top+"个数字"+elements[top]+"移除数字栈");
        return elements[top--];
    }
    public void add(double value){
        System.out.println("第"+(top+1)+"个入栈的数字是"+value);
        elements[++top]=value;
    }
    public boolean isEmpty(){
        return top==0;
    }
}
