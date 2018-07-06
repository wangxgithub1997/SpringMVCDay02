package com.jf.weidong.exception2;

/**
 * 处理三层异常
 * Dao   抛出，不处理
 * Service 抛出，不处理
 * Controller 抛出，不处理
 *   SpringMVC 的 @ControllerAdvice 切面拦截所有异常
 *   需要判断请求类型
 *      普通访问
 *      ajax访问
 */
public class T {
}
