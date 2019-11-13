package com.travel.one.four.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {
    @RequestMapping("/t")
    public String m1(){
        return "ddd";
    }
}
