package com.redding.rbac.web.controller;

import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.service.EnterpriseService;
import com.redding.rbac.web.annotation.OuterResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
