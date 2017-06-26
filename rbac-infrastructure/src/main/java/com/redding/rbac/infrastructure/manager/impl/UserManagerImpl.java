package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.commons.constant.DefaultStateEnum;
import com.redding.rbac.commons.pojo.dto.UserEditDto;
import com.redding.rbac.commons.pojo.query.UserQuery;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.infrastructure.domain.OrganizationUser;
import com.redding.rbac.infrastructure.domain.User;
import com.redding.rbac.infrastructure.domain.UserRole;
import com.redding.rbac.infrastructure.manager.UserManager;
import com.redding.rbac.infrastructure.mapper.OrganizationUserMapper;
import com.redding.rbac.infrastructure.mapper.UserMapper;
import com.redding.rbac.infrastructure.mapper.UserRoleMapper;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagerImpl extends DefaultManager<User> implements UserManager {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrganizationUserMapper organizationUserMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<User> queryOrgUsers(UserQuery userQuery) {
        return userMapper.selectOrgUsers(userQuery);
    }

    @Override
    public int save(UserEditDto userEditDto) {
        User user = BeanMapper.map(userEditDto, User.class);
        user.setState(DefaultStateEnum.ENABLED.getValue());
        user.setPostState(DefaultStateEnum.ENABLED.getValue());
        int userResult = userMapper.insertSelective(user);
        if(userResult > 0){
            List<UserRole> userRoles = new ArrayList<UserRole>();
            List<OrganizationUser> orgUser = new ArrayList<OrganizationUser>();
            userEditDto.getRoleIds().forEach(r -> {
                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleId(r);
                userRoles.add(userRole);
            });
            userEditDto.getOrganizationIds().forEach(o -> {
                OrganizationUser organizationUser = new OrganizationUser();
                organizationUser.setOrganizationId(o);
                organizationUser.setUserId(user.getId());
                orgUser.add(organizationUser);
            });
            organizationUserMapper.insertList(orgUser);
            userRoleMapper.insertList(userRoles);
        }
        return userResult;
    }

    @Override
    public int update(UserEditDto userEditDto) {
        User user = BeanMapper.map(userEditDto, User.class);
        user.setCreatedDate(null);
        user.setUpdatedDate(null);
        int userResult = userMapper.updateByPrimaryKeySelective(user);
        if (userResult > 0) {
            List<UserRole> userRoles = new ArrayList<UserRole>();
            List<OrganizationUser> orgUser = new ArrayList<OrganizationUser>();
            userEditDto.getRoleIds().forEach(r -> {
                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleId(r);
                userRoles.add(userRole);
            });
            userEditDto.getOrganizationIds().forEach(o -> {
                OrganizationUser organizationUser = new OrganizationUser();
                organizationUser.setOrganizationId(o);
                organizationUser.setUserId(user.getId());
                orgUser.add(organizationUser);
            });
            // 先删除,再插入
            OrganizationUser orgUserDeleteQuery = new OrganizationUser();
            orgUserDeleteQuery.setUserId(userEditDto.getId());
            organizationUserMapper.delete(orgUserDeleteQuery);
            organizationUserMapper.insertList(orgUser);
            UserRole userRoleDeleteQuery = new UserRole();
            userRoleDeleteQuery.setUserId(userEditDto.getId());
            userRoleMapper.delete(userRoleDeleteQuery);
            userRoleMapper.insertList(userRoles);
        }
        return userResult;
    }
}