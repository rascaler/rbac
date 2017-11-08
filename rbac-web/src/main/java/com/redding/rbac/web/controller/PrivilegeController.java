package com.redding.rbac.web.controller;

import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.PrivilegeDto;
import com.redding.rbac.commons.pojo.dto.PrivilegeEditDto;
import com.redding.rbac.commons.pojo.dto.RoleDto;
import com.redding.rbac.commons.pojo.dto.RoleEditDto;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.commons.pojo.query.PrivilegeQuery;
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
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @RequestMapping(value = "/getPrivileges", method = RequestMethod.GET)
    @OuterResponseBody
    List<PrivilegeDto> getPrivileges() {
        return privilegeService.getPrivileges(SessionUtils.getUserAuth().getId());
    }

    @RequestMapping(value = "/pagePrivileges", method = RequestMethod.GET)
    @OuterResponseBody
    PageInfo<PrivilegeDto> getPrivileges(PageParams pageParams, PrivilegeQuery query) {
        return privilegeService.pagePrivileges(pageParams, query);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @OuterResponseBody
    void save(@RequestBody @Validated(value = {Add.class}) PrivilegeEditDto privilegeEditDto) {
//        privilegeEditDto.setEnterpriseId(SessionUtils.getUserAuth().getEnterpriseId());
//        if(null == privilegeEditDto.getMenuIds() || privilegeEditDto.getMenuIds().size() == 0)
//            throw new SPIException(BasicEcode.FAILED); //todo
//        privilegeService.save(privilegeEditDto);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @OuterResponseBody
    void update(@RequestBody @Validated(value = {Update.class}) PrivilegeEditDto privilegeEditDto) {
//        privilegeEditDto.setEnterpriseId(SessionUtils.getUserAuth().getEnterpriseId());
//        if(null == privilegeEditDto.getMenuIds() || privilegeEditDto.getMenuIds().size() == 0)
//            throw new SPIException(BasicEcode.FAILED); //todo
//        privilegeService.update(privilegeEditDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @OuterResponseBody
    void delete(@RequestParam Integer id) {
        privilegeService.delete(id);
    }

    @RequestMapping(value = "/getEditDetail", method = RequestMethod.GET)
    @OuterResponseBody
    PrivilegeEditDto getEditDetail(@RequestParam Integer id) {
        return privilegeService.getEditDetail(id);
    }
}
