package com.nown.controller;

import com.nown.service.ScienceService;
import com.nown.service.SimpleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/")
public class MyController {
    //首页
    @GetMapping
    public String view(){
        return "business";
    }

    //四则计算器
    @GetMapping("/Simple")
    public String Simple(Model model){
        model.addAttribute("answer","answer");
        return "simple";
    }

    @PostMapping("/Simple")
    @ResponseBody
    public String getSimpleAnswer(@RequestParam("question") String question,Model model) {
        System.out.println("未解析前，question= "+question);
        String ans="";
        String q="";
        try{
            q=java.net.URLDecoder.decode(question,"UTF-8");
            System.out.println("解析后，question= "+q);
        }catch (Exception e){
            ans="解析错误";
        }
        SimpleService simpleService=new SimpleService(q);
        ans=simpleService.getAnswer();
        System.out.println("结果是："+ans);
        return ans;
    }

    //商务计算器
    @GetMapping("/Business")
    public String Business(){return "business";}

    //科学计算器
    @GetMapping("/Science")
    public String Science(Model model){
        model.addAttribute("answer","answer");
        return "science";
    }
    @PostMapping("/Science")
    @ResponseBody
    public String getScienceAnswer(@RequestParam("question") String question,Model model) {
        System.out.println("未解析前，question= "+question);
        String ans="";
        String q="";
        try{
            q=java.net.URLDecoder.decode(question,"UTF-8");
            System.out.println("解析后，question= "+q);
        }catch (Exception e){
            ans="解析错误";
        }
        ScienceService scienceService=new ScienceService(q);
        ans=scienceService.getAnswer();
        System.out.println("结果是："+ans);
        return ans;
    }

    //贷款计算器
    @GetMapping("/Loan")
    public String Loan(){return "loan";}

    //进制计算器
    @GetMapping("/Base")
    public String Base(){return "base";}
}
