package com.jf.weidong.exception;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void login(User user)throws UserException{
        if (user.getName() == null || user.getPassword() == null) {
            //抛出一个UserException
            throw new UserException("用户名或密码不能为空");
//            throw new RuntimeException();
        }
        System.out.println("正常的逻辑");
    }


}



