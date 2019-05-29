package com.aaa.controller;

import com.aaa.entity.Module;
import com.aaa.service.IModuleService;
import com.aaa.service.impl.ModuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ModuleController{
    @Autowired
    private IModuleService moduleService;
    @RequestMapping("queryMenu")
    @ResponseBody
    public List<Module> queryMenu(HttpSession session){
        System.out.println(session.getAttribute("role").toString()+"---");
        List<Module> list = moduleService.selByAccountName(session.getAttribute("role").toString());
        System.out.println(list.toString());
        return list;
    }
}
