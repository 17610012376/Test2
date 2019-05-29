package com.aaa.controller;



import com.aaa.entity.Client;
import com.aaa.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ClientController {
    @Resource
    private IClientService clientService;
    @RequestMapping("/loginPage")
    public String frontLogin(){
        return "frontLogin";
    }

        @RequestMapping("/loginButton")
        public String toLogin(String phone, String clientPassword,Model model,HttpSession session) {
            System.out.println("登录");
            //验证用户名和密码是否正确
            Client client = clientService.login(phone,clientPassword);
            if (StringUtils.isEmpty(client)||client==null) {
               model.addAttribute("errorInfo", "错了错了");
                return "redirect:/frontLogin";
            }
            session.setAttribute("sessionClient", client);
            return "index";
        }

        @RequestMapping("/register")
        public String register(){

        return "register";
    }
    @RequestMapping("/registerPage")
    public String toRegister(HttpServletRequest request){
        System.out.println("注册");
        String clientName=request.getParameter("clientName");
        String clientPassword=request.getParameter("clientPassword");
        String clientPassword2=request.getParameter("clientPassword2");
        String phone = request.getParameter("phone");


            Client client = new Client();
            client.setClientName(clientName);
            client.setClientPassword(clientPassword);
            client.setClientPassword2(clientPassword2);
            client.setPhone(phone);
            clientService.register(client);
            return  "redirect:/loginPage";


    }


    }

