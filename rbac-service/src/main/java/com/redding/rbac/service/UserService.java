package com.redding.rbac.service;


import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.UserDetailDto;
import com.redding.rbac.commons.pojo.dto.UserDto;
import com.redding.rbac.commons.pojo.dto.UserEditDto;
import com.redding.rbac.commons.pojo.query.UserQuery;
import com.redding.rbac.commons.utils.PageParams;

public interface UserService {
    /**
     * 分页查询用户
     *
     * @param userQuery
     * @param pageParams
     * @return
     * @throws SPIException
     */
    PageInfo<UserDto> pageUsers(UserQuery userQuery, PageParams pageParams) throws SPIException;

    /**
     * 添加或保存用户
     *
     * @param userEditDto
     */
    void saveOrUpdate(UserEditDto userEditDto);

    /**
     * 获取用户详情
     *
     * @param userId
     * @param enterpriseId
     * @return
     */
    UserDetailDto getUserDetail(Integer userId, Integer enterpriseId);

    /**
     * 离职
     *
     * @param id
     * @param postState
     * @param enterpriseId
     */
    void updatePostState(Integer id, Integer postState, Integer enterpriseId);

    /**
     * 修改账户状态
     * @param id
     * @param state
     * @param enterpriseId
     */
    void updateState(Integer id, Integer state, Integer enterpriseId);
}