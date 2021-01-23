package com.nown.utils;

import com.nown.service.ScienceService;
import com.nown.service.SimpleService;
import com.nown.utils.calculator.ScienceCalculator;
import org.springframework.cglib.core.Converter;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String []args){
//        String question="1+((22+33)*4+7)+6/4";//输出229.5，运算结果正确
//        String question="(-4)";//输出-4，结果正确
//        String question="(-4)*(-6)";//输出24，结果正确
//        SimpleService simpleService=new SimpleService(question);
//        System.out.println("答案是："+simpleService.getAnswer());
//        char ope='/';
//        if(ope=='+'){
//            System.out.println("加号，ope是"+ope);
//        }else if(ope=='/'){
//            System.out.println("除号，ope是"+ope);
//        }else{
//            System.out.println("啥也不是，ope是"+ope);
//        }
//        String question ="s(p/2)";//结果为1，正确
//        String question ="21*s(p/2)+3";//结果是24，正确
//        String question ="1+q(3^2)";//结果是4，正确
//        String question ="1+a(-3^2)";//结果是10，正确
//        String question ="1+(-3)^3";//结果是-26，正确
//
//        ScienceService scienceService=new ScienceService(question);
//        System.out.println(scienceService.getAnswer());
//        double [] a=new double[3];
//        for(int i=0;i<3;i++){
//            a[i]=i+2;
//        }
//        System.out.println(Arrays.toString(a));
    }
}
