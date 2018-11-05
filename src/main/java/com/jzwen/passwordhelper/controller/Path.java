package com.jzwen.passwordhelper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Path {

    @RequestMapping("index")
    public String goIndex(){
        return "index";
    }

    @RequestMapping("login")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("homepage")
    public String goHomePage(){
        return "homepage";
    }
}

