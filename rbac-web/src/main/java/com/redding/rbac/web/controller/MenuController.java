package com.redding.rbac.web.controller;

import com.redding.rbac.commons.pojo.dto.MenuNodeDto;
import com.redding.rbac.service.MenuService;
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
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/getAppMenus", method = RequestMethod.GET)
    @OuterResponseBody
    List<MenuNodeDto> getAppMenus(@RequestParam Integer appId) {
        return menuService.getAppMenus(appId);
    }



}
