package com.jf.weidong.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义异常
 */
//@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "用户名或密码不能为空")
public class UserException extends RuntimeException{
    public UserException() {
    }
    public UserException(String message) {
        super(message);
    }
}