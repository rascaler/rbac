package com.redding.rbac.web.controller;

import com.redding.rbac.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
public class HelloController {

    @Autowired
    private EnterpriseService enterpriseService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        enterpriseService.getById(1);
        return "Hello World!";
    }


}
