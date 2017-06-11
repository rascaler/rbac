package com.redding.rbac.web.controller;

import com.redding.rbac.commons.pojo.dto.EnterpriseDto;
import com.redding.rbac.commons.pojo.dto.RoleDto;
import com.redding.rbac.service.RoleService;
import com.redding.rbac.web.utils.annotation.OuterResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @OuterResponseBody
    List<RoleDto> getAll() {
        return roleService.getAll(EnterpriseDto.ENTERPRISE_ID_MOCK);
    }

    @RequestMapping(value = "/getOrganizationRoles", method = RequestMethod.GET)
    @OuterResponseBody
    List<RoleDto> getOrganizationRoles(@RequestParam Integer organizationId) {
        return roleService.getOrganizationRoles(organizationId ,EnterpriseDto.ENTERPRISE_ID_MOCK);
    }



}
