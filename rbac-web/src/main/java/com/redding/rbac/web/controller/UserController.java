package com.redding.rbac.web.controller;

import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.pojo.dto.*;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.commons.pojo.query.UserQuery;
import com.redding.rbac.commons.utils.PageParams;
import com.redding.rbac.commons.utils.validation.Add;
import com.redding.rbac.commons.utils.validation.Update;
import com.redding.rbac.service.UserService;
import com.redding.rbac.web.utils.SessionUtils;
import com.redding.rbac.web.utils.annotation.OuterResponseBody;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @param userQuery
     * @param pageParams
     * @return
     */
    @RequestMapping(value = "/pageUsers", method = RequestMethod.GET)
    @OuterResponseBody
    PageInfo<UserDto> pageUsers(UserQuery userQuery, PageParams pageParams) {
        userQuery.setEnterpriseId(EnterpriseDto.ENTERPRISE_ID_MOCK);
        return userService.pageUsers(userQuery,pageParams);
    }


    /**
     * @param userEditDto
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @OuterResponseBody
    void save(@RequestBody @Validated(value = {Add.class}) UserEditDto userEditDto) {
        UserAuthDto userAuthDto = SessionUtils.getUserAuth();
        userEditDto.setEnterpriseId(userAuthDto.getEnterpriseId());
        userService.saveOrUpdate(userEditDto);
    }

    /**
     * @param userEditDto
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @OuterResponseBody
    void update(@RequestBody @Validated(value = {Update.class}) UserEditDto userEditDto) {
        UserAuthDto userAuthDto = SessionUtils.getUserAuth();
        userEditDto.setEnterpriseId(userAuthDto.getEnterpriseId());
        userService.saveOrUpdate(userEditDto);
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @OuterResponseBody
    UserDetailDto getUserDetail(@RequestParam Integer id) {
        return userService.getUserDetail(id, SessionUtils.getUserAuth().getEnterpriseId());
    }

    /**
     * @param id
     * @param postState
     */
    @RequestMapping(value = "/leave", method = RequestMethod.POST)
    @OuterResponseBody
    void leave(@RequestParam Integer id, @RequestParam Integer postState){
        userService.updatePostState(id, postState, SessionUtils.getUserAuth().getEnterpriseId());
    }

    /**
     * @param id
     * @param state
     */
    @RequestMapping(value = "/updateState", method = RequestMethod.POST)
    @OuterResponseBody
    void updateState(@RequestParam Integer id, @RequestParam Integer state){
        userService.updateState(id, state, SessionUtils.getUserAuth().getEnterpriseId());
    }


}
