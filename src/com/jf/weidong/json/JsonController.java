package com.jf.weidong.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @RequestMapping("/testJson")
    @ResponseBody
    public User testJson(){
        User user = new User();
        user.setName("lisi");
        user.setPassword("admin");
        return user;
    }

    //可以返回json个数的数据
    //接受json格式的数据  {name:admin,password:admin}
    @RequestMapping("/testJson2")
    @ResponseBody
    public User testJson2(@RequestBody User user){
        System.out.println(user.toString());
        return user;
    }



}
