package com.jf.weidong.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    /**
     * /admin/addAdmin
     */
    @RequestMapping("/addAdmin")
    @ResponseBody
    public String addAdmin() {
        return "addAdmin";
    }

    /**
     * 让方法只能用post、get进行访问
     */
    @RequestMapping(value = "/getAdmin", method = RequestMethod.GET)
    @ResponseBody
    public String getAdmin() {
        return "getAdmin";
    }


}
