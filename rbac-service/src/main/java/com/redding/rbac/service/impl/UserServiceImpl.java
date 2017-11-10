package com.redding.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.constant.RbacEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.*;
import com.redding.rbac.commons.pojo.dto.auth.LoginForm;
import com.redding.rbac.commons.pojo.dto.auth.RoleAuthDto;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.commons.pojo.query.UserQuery;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.commons.utils.PageParams;
import com.redding.rbac.infrastructure.domain.*;
import com.redding.rbac.infrastructure.manager.*;
import com.redding.rbac.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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

    @Override
    public void updatePostState(Integer id, Integer postState, Integer enterpriseId) {
        User userUpdate = new User();
        userUpdate.setPostState(postState);
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", id).andEqualTo("enterpriseId", enterpriseId);
        if(userManager.updateByExampleSelective(userUpdate, example) <= 0){
            logger.error("用户id={},enterpriseId={}不存在", id, enterpriseId);
            throw new SPIException(BasicEcode.FAILED);
        }
    }

    @Override
    public void updateState(Integer id, Integer state, Integer enterpriseId) {
        User userUpdate = new User();
        userUpdate.setState(state);
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", id).andEqualTo("enterpriseId", enterpriseId);
        userManager.updateByExampleSelective(userUpdate, example);
        if(userManager.updateByExampleSelective(userUpdate, example) <= 0){
            logger.error("用户id={},enterpriseId={}不存在", id, enterpriseId);
            throw new SPIException(BasicEcode.FAILED);
        }
    }

    @Override
    public UserAuthDto getUserAuth(String username) {
        UserAuthDto userAuth = new UserAuthDto();
        User query = new User();
        query.setUsername(username);
        User user = userManager.selectOne(query);
        if(null == user)
            throw new SPIException(BasicEcode.USER_ERR_LOGIN);
        userAuth = BeanMapper.map(user, UserAuthDto.class);
        // todo 获取角色
        List<RoleAuthDto> roles = new ArrayList<RoleAuthDto>();
        RoleAuthDto role1 = new RoleAuthDto();
        role1.setId(1);
        role1.setCode("admin");
        role1.setName("超级管理员");
        roles.add(role1);
        userAuth.setRoles(roles);
        // todo 获取权限
        role1.setPrivileges(new ArrayList<String>(){{ add("admin:role"); }});
        return userAuth;
    }

    @Override
    public boolean validateUser(LoginForm loginForm) throws SPIException {
        User query = new User();
        query.setUsername(loginForm.getUsername());
        query.setPassword(loginForm.getPassword());
        User user = userManager.selectOne(query);
        if(null == user)
            return false;
        else
            return true;
    }
}