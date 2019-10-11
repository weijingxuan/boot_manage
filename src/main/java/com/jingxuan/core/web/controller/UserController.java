package com.jingxuan.core.web.controller;

import com.jingxuan.core.po.User;
import com.jingxuan.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 用户登录
     */
    @RequestMapping(value="login.action",method= RequestMethod.POST)
    public String login(String usercode, String password, Model model, HttpSession session){
        //通过账户和密码查询用户
        User user=userService.findUser(usercode,password);
        if(user!=null){
            session.setAttribute("USER_SESSION",user);
            return "redirect:customer/list.action";
        }
        model.addAttribute("msg","账号或密码错误，请重新输入");
        return "login";
    }

    @RequestMapping("/toCustomer.action")
    public String toCustomer(){
        return "customer";
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session){
        //清除session
        session.invalidate();
        return "redirect:login.action";
    }

    @RequestMapping(value = "login.action",method=RequestMethod.GET)
    public String toLogin(){
        return "login";
    }
}
