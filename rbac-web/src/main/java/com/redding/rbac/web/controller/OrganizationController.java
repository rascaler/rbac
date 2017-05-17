package com.redding.rbac.web.controller;

import com.redding.rbac.service.EnterpriseService;
import com.redding.rbac.service.OrganizationService;
import com.redding.rbac.service.OrganizationUserService;
import com.redding.rbac.web.utils.annotation.OuterResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/getOrgTree", method = RequestMethod.GET)
    @OuterResponseBody
    String home() {
        return "Hello World!";
    }


}
