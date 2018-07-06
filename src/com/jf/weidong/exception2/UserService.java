package com.jf.weidong.exception2;

import org.omg.CORBA.UserException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserDao userDao;

    public void addUser(Integer id)throws Exception {
        //模拟抛出异常
        switch (id) {
            case 1:
                throw new BusinessException("Service系统业务异常", "11");
            case 2:
                throw new ParameterException("Service参数错误异常", "22");
            default:
                throw new NullPointerException();
        }
    }

    //调用Dao抛出异常
    public void addUser2(Integer id)throws Exception {
        userDao.addUser(id);
    }



    //不抛出异常
    public void getUser(){
        System.out.println("UserService  getUser");
        userDao.getUser();
    }


}



