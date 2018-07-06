package com.jf.weidong.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor2 implements HandlerInterceptor {


    /**
     * Controller 执行前调用此方法
     * 返回true表示继续执行，返回false终止执行(包括之后的拦截器和控制器（Controller）)
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("MyInterceptor2   preHandle...");
        return false;
    }

    /**
     * Controller执行之后，且在视图解析之前执行
     * 这里可以在数据返回用户前进行视图加工
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor2  postHandle...");
    }

    /**
     * 整个请求执行完毕，即视图解析渲染结束后执行
     * 释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("MyInterceptor2   afterCompletion...");
    }
}
