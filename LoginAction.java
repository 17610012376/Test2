package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAction {
    /**
     * 显示登录
     * @return
     */
    @RequestMapping("frontLogin")
    public String frontLogin(){
        return "frontLogin";
    }

  /*  @RequestMapping("register")
    public String register(){
        return "register";
    }*/
}
