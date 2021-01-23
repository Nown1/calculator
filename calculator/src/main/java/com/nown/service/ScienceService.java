package com.nown.service;

import com.nown.utils.calculator.ScienceCalculator;


public class ScienceService {
    private String question;
    ScienceCalculator calculator;

    public ScienceService(String question){
        this.question=question;
        calculator=new ScienceCalculator(question);
    }
    public String getAnswer(){
        return calculator.getAnswer();
    }
}
