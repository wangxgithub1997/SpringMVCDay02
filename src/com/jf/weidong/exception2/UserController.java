package com.jf.weidong.exception2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/exception")
    public void addUser(Integer id)throws Exception {
        //模拟抛出异常
        switch (id) {
            case 1:
                throw new BusinessException("Controller系统业务异常", "11");
            case 2:
                throw new ParameterException("Controller参数错误异常", "22");
            case 3://Service业务异常
                userService.addUser(1);
                break;
            case 4://Service参数异常
                userService.addUser(2);
                break;
            case 5://Dao业务异常
                userService.addUser2(1);
                break;
            case 6://Dao参数异常
                userService.addUser2(2);
                break;
            case 7://Controller发生了未知异常
                throw new RuntimeException("Controller   未知的异常");
        }
    }
    @RequestMapping("/getUser")
    public String getUser(){
        return "index.jsp";
    }


}
