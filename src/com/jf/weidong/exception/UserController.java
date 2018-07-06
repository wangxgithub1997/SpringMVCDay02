package com.jf.weidong.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/login")
    public String login(User user){
        userService.login(user);
        return "index.jsp";
    }

//    //只能处理当前Controller的异常
//    //处理异常的方法
//    @ExceptionHandler(UserException.class)
//    public String handlerUserException(){
//        return "error.jsp";
//    }



}
