package com.jf.weidong.exception2;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理全局的异常
 */
@ControllerAdvice
public class AppException {

    @ExceptionHandler({BusinessException.class,ParameterException.class,RuntimeException.class})
    public ModelAndView handlerUserException(HttpServletRequest req, HttpServletResponse resp, Exception e) throws IOException {
        //普通请求：发送异常直接跳转到错误页面
        //ajax请求：返回错误的json数据 {"msg":"xxx业务异常",code:11} 、  xxx异常
        //判断请求的类型
        if(req.getHeader("X-Requested-With") != null
                && req.getHeader("X-Requested-With")
                .equalsIgnoreCase("XMLHttpRequest")){
            resp.setCharacterEncoding("utf-8");
            if (e instanceof BusinessException) {
                BusinessException be = (BusinessException) e;
                //ajax请求
                resp.getWriter().write(e.getMessage()+"  " + be.getCode());
                return null;
            }else {
                //ajax请求
                resp.getWriter().write(e.getMessage());
            }
        }else{
            //如果发生了业务异常，那么跳转到error-business.jsp
            //如果发生了参数异常，那么跳转到error-parameter.jsp
            Map<String,Object> model = new HashMap<>();
            model.put("ex", e);
            if (e instanceof BusinessException) {
                //跳转到业务异常页面
                return new ModelAndView("WEB-INF/errors/error-business.jsp",model);
            }else if(e instanceof ParameterException){
                //跳转到参数异常页面
                return new ModelAndView("WEB-INF/errors/error-parameter.jsp",model);
            }else{
                //跳转到默认异常页面
                return new ModelAndView("WEB-INF/errors/error.jsp",model);
            }
        }
        return null;
    }

}
