package com.jf.weidong.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//http://guolin.tech/api/china/
@Controller
public class RestFulController {
    //如果方法不添加@ResponseBody注解，那么返回值（String）表示视图名

    //  /user/1
    @RequestMapping("/user/{id}")
    @ResponseBody
    public String restFul(@PathVariable("id") Integer id){
        System.out.println("restFul......");
        return id +"   ";
    }




}
