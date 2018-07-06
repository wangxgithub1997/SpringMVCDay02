package com.jf.weidong.interceptor.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    /**
     * 跳转到登陆页面
     */
    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String toLogin(){
        return "/WEB-INF/jsp/login.jsp";
    }

    /**
     * 跳转到用户主页
     */
    @RequestMapping(value = "/toMain")
    public String toMain(){
        return "/WEB-INF/jsp/main.jsp";
    }

    /**
     * 退出登陆
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/toLogin";
    }

    @RequestMapping("/login")
    public String login(User user, HttpSession session, Model model){
        String username = user.getName();
        String password = user.getPassword();
        if(username != null && username.equals("admin") &&
                password != null && password.equals("admin")){
            session.setAttribute("USER_SESSION", user);
            return "redirect:/toMain";
        }else{
            model.addAttribute("msg", "用户名或密码错误");
            return "/WEB-INF/jsp/login.jsp";
        }
    }






}
