package com.tradingplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: Tradingplatform
 * @description:
 * @author: Robert_Wang
 * @create: 2018-08-17 18:57
 **/
@Controller
@RequestMapping({"/","/hello","/homepage"})
public class HelloController {

    @RequestMapping("/mvc")
    public String helloSay(){
        return "home";
    }
    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "/index.jsp";
    }
}
