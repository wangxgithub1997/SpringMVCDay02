package com.jf.weidong.exception2;

/**
 * 参数错误异常
 */
public class ParameterException extends RuntimeException {
    private String code;//异常码

    public ParameterException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
