package com.nown.service;

import com.nown.utils.calculator.SimpleCalculator;

public class SimpleService {
    private String question;
    SimpleCalculator calculator;

    public SimpleService(String question){
        this.question=question;
        calculator=new SimpleCalculator(question);
    }
    public String getAnswer(){
        return calculator.getAnswer();
    }
}
