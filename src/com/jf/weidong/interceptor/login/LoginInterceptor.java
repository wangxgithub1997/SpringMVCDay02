package com.jf.weidong.interceptor.login;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("MyInterceptor   preHandle...");
        String url = httpServletRequest.getRequestURI();
        if (url.indexOf("/toLogin") >= 0) {//访问登陆的路径不需要拦截
            return true;
        }
        HttpSession httpSession = httpServletRequest.getSession();
        User user = (User) httpSession.getAttribute("USER_SESSION");
        //已经登陆
        if (user != null) {
            return true;
        }

        httpServletRequest.setAttribute("msg","请先登陆");
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(httpServletRequest,httpServletResponse);
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor   postHandle...");
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("MyInterceptor   afterCompletion...");
    }
}
