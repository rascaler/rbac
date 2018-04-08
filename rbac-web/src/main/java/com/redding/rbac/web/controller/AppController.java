package com.redding.rbac.web.controller;

import com.redding.rbac.commons.pojo.dto.AppDto;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.commons.utils.PageParams;
import com.redding.rbac.commons.utils.validation.Add;
import com.redding.rbac.commons.utils.validation.Update;
import com.redding.rbac.service.AppService;
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
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppService appService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @OuterResponseBody
    List<AppDto> getAll() {
        return appService.getAll();
    }


    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @OuterResponseBody
    AppDto getOne() {
        return appService.getOne();
    }
}
