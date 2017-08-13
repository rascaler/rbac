package com.redding.rbac.web.controller;

import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.pojo.dto.*;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.commons.pojo.query.RoleQuery;
import com.redding.rbac.commons.utils.PageParams;
import com.redding.rbac.commons.utils.validation.Add;
import com.redding.rbac.commons.utils.validation.Update;
import com.redding.rbac.service.RoleService;
import com.redding.rbac.web.utils.SessionUtils;
import com.redding.rbac.web.utils.annotation.OuterResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        return roleService.getAll(SessionUtils.getUserAuth().getEnterpriseId());
    }

    @RequestMapping(value = "/getUserRoles", method = RequestMethod.GET)
    @OuterResponseBody
    List<RoleDto> getUserRoles() {
        UserAuthDto userAuthDto = SessionUtils.getUserAuth();
        return roleService.getUserRoles(userAuthDto.getId(), userAuthDto.getEnterpriseId());
    }

    @RequestMapping(value = "/pageRoles", method = RequestMethod.GET)
    @OuterResponseBody
    PageInfo<RoleDto> pageRoles(RoleQuery roleQuery, PageParams pageParams) {
        UserAuthDto userAuthDto = SessionUtils.getUserAuth();
        return roleService.pageRoles(roleQuery, pageParams);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @OuterResponseBody
    void save(@Validated(value = {Add.class}) @RequestBody RoleEditDto roleEditDto) {
        UserAuthDto userAuthDto = SessionUtils.getUserAuth();
        roleEditDto.setEnterpriseId(userAuthDto.getEnterpriseId());
        roleService.save(roleEditDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @OuterResponseBody
    void update(@Validated(value = {Update.class}) @RequestBody RoleEditDto roleEditDto) {
        UserAuthDto userAuthDto = SessionUtils.getUserAuth();
        roleEditDto.setEnterpriseId(userAuthDto.getEnterpriseId());
        roleService.update(roleEditDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @OuterResponseBody
    void delete(@RequestParam Integer id) {
        roleService.delete(id);
    }

    @RequestMapping(value = "/updateState", method = RequestMethod.POST)
    @OuterResponseBody
    void upateState(@RequestParam Integer id,@RequestParam Integer state) {
        RoleDto role = new RoleDto();
        role.setState(state);
        role.setEnterpriseId(SessionUtils.getUserAuth().getEnterpriseId());
        role.setId(id);
        roleService.updateState(role);
    }

    @RequestMapping(value = "/editDetail", method = RequestMethod.GET)
    @OuterResponseBody
    RoleEditDto editDetail(@RequestParam Integer id) {
        return roleService.getEditDetail(id, SessionUtils.getUserAuth().getEnterpriseId());
    }
}
