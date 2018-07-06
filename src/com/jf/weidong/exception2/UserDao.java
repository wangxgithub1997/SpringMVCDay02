package com.jf.weidong.exception2;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void addUser(Integer id) throws Exception {
        //模拟抛出异常
        switch (id) {
            case 1:
                throw new BusinessException("Dao系统业务异常", "11");
            case 2:
                throw new ParameterException("Dao参数错误异常", "22");
            default:
                throw new NullPointerException();
        }
    }

    public void getUser(){
        System.out.println("Dao getUser");
    }

}
