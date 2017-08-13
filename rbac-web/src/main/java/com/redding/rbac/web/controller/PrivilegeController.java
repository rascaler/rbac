package com.redding.rbac.web.controller;

import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.pojo.dto.PrivilegeDto;
import com.redding.rbac.commons.pojo.dto.RoleDto;
import com.redding.rbac.commons.pojo.dto.RoleEditDto;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.commons.pojo.query.RoleQuery;
import com.redding.rbac.commons.utils.PageParams;
import com.redding.rbac.commons.utils.validation.Add;
import com.redding.rbac.commons.utils.validation.Update;
import com.redding.rbac.service.PrivilegeService;
import com.redding.rbac.service.RoleService;
import com.redding.rbac.web.utils.SessionUtils;
import com.redding.rbac.web.utils.annotation.OuterResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @RequestMapping(value = "/getPrivileges", method = RequestMethod.GET)
    @OuterResponseBody
    List<PrivilegeDto> getPrivileges() {
        return privilegeService.getPrivileges(SessionUtils.getUserAuth().getId());
    }

}
