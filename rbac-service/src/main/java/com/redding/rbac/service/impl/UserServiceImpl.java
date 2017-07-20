package com.redding.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.constant.RbacEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.*;
import com.redding.rbac.commons.pojo.query.UserQuery;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.commons.utils.PageParams;
import com.redding.rbac.infrastructure.domain.*;
import com.redding.rbac.infrastructure.manager.*;
import com.redding.rbac.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserRoleManager userRoleManager;

    @Autowired
    private RoleManager roleManager;

    @Autowired
    private OrganizationUserManager organizationUserManager;

    @Autowired
    private OrganizationManager organizationManager;

    @Override
    public PageInfo<UserDto> pageUsers(UserQuery userQuery,PageParams pageParam) throws SPIException {
        if(StringUtils.isNotEmpty(userQuery.getKeyword()))
            userQuery.setKeyword(userQuery.getKeyword() + "%");
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), pageParam.getOrderBy());
        List<User> users = userManager.queryOrgUsers(userQuery);
        PageInfo pageInfo = new PageInfo(users);
        pageInfo.setList(BeanMapper.mapList(pageInfo.getList(), UserDto.class));
        return pageInfo;
    }

    @Override
    public void saveOrUpdate(UserEditDto userEditDto) {
        if (null == userEditDto.getId()) { //新增
            userManager.save(userEditDto);
        } else {
            userManager.update(userEditDto);
        }
    }

    @Override
    public UserDetailDto getUserDetail(Integer id, Integer enterpriseId) {
        User userQuery = new User();
        userQuery.setId(id);
        userQuery.setEnterpriseId(enterpriseId);
        User user = userManager.selectOne(userQuery);
        if(null == user)
        throw new SPIException(RbacEcode.USER_NOT_EXISTS);
        UserDetailDto detail = BeanMapper.map(user, UserDetailDto.class);
        //查询角色, 只查询用户被分配的角色
        UserRole userRoleQuery = new UserRole();
        userRoleQuery.setUserId(id);
        List<UserRole> userRoles = userRoleManager.selectList(userRoleQuery);
        if (null != userRoles && userRoles.size() > 0) {
        Example example = new Example(Role.class);
        example.createCriteria().andIn("id", userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()));
        List<Role> roles = roleManager.selectByExample(example);
        detail.setRoles(BeanMapper.mapList(roles, RoleDto.class));
        }
        // 查询用户所属组织
        OrganizationUser userOrgQuery = new OrganizationUser();
        userOrgQuery.setUserId(id);
        List<OrganizationUser> organizationUsers = organizationUserManager.selectList(userOrgQuery);
        if (null != organizationUsers && organizationUsers.size() > 0) {
            Example orgExample = new Example(Organization.class);
            orgExample.createCriteria().andIn("id", organizationUsers.stream().map(OrganizationUser::getOrganizationId).collect(Collectors.toList()));
            List<Organization> orgs = organizationManager.selectByExample(orgExample);
            detail.setOrganizations(BeanMapper.mapList(orgs, OrganizationDto.class));
        }
        return detail;
    }
}