package com.aaa.controller;

import com.aaa.entity.Account;
import com.aaa.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/login")
    public String login(Account account, Model model, HttpSession session){
        Account acc = accountService.selByAccount(account);
        System.out.println(acc+"______");
        if(acc!=null){

            session.setAttribute("users",acc.getUsers().getUserName());
            session.setAttribute("role",acc.getRole().getRoleName());
            return "main";
        }else{
            model.addAttribute("error","用户名或密码错误");
            return "forward:/login";
        }

    }
}
