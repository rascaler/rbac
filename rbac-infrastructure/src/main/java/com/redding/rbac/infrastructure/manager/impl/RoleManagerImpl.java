package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.constant.DefaultStateEnum;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.RoleDto;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.infrastructure.domain.*;
import com.redding.rbac.infrastructure.manager.RoleManager;
import com.redding.rbac.infrastructure.mapper.*;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleManagerImpl extends DefaultManager<Role> implements RoleManager {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePrivilegeMapper rolePrivilegeMapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private OrganizationUserMapper organizationUserMapper;

    @Autowired
    private OrganizationRoleMapper organizationRoleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> getAll(Integer enterpriseId) {
        Role query = new Role();
        query.setEnterpriseId(enterpriseId);
        return roleMapper.select(query);
    }

    @Override
    public List<RoleDto> queryUserRoles(Integer userId, Integer enterpriseId) {
        return roleMapper.selectUserRoles(userId,enterpriseId);
    }

    @Override
    public int save(Role role, List<RolePrivilege> rolePrivileges) {
        int result = roleMapper.insertSelective(role);
        if(result > 0) {
            rolePrivileges.forEach(r -> r.setRoleId(role.getId()));
            rolePrivilegeMapper.insertList(rolePrivileges);
        }
        return result;
    }

    @Override
    public List<Role> getUserRoles(Integer userId) {
        //先查询用户当前组织所拥有的角色
        Set<Integer> roleIds = new HashSet<Integer>();
        OrganizationUser orgUserQuery = new OrganizationUser();
        orgUserQuery.setUserId(userId);
        List<OrganizationUser> orgUsers = organizationUserMapper.select(orgUserQuery);
        if(null != orgUsers && orgUsers.size() > 0){
            Example orgRoleExample = new Example(OrganizationRole.class);
            orgRoleExample.createCriteria().andIn("organizationId", orgUsers.stream().map(OrganizationUser::getOrganizationId).collect(Collectors.toList()));
            List<OrganizationRole> orgRoles = organizationRoleMapper.selectByExample(orgRoleExample);
            if(null != orgRoles && orgRoles.size() > 0){
                roleIds.addAll(orgRoles.stream().map(OrganizationRole::getRoleId).collect(Collectors.toList()));
            }
        }
        //查询用户当前所分配的角色
        UserRole userRoleQuery = new UserRole();
        userRoleQuery.setUserId(userId);
        List<UserRole> userRoles = userRoleMapper.select(userRoleQuery);
        if(null != userRoles && userRoles.size() > 0)
            roleIds.addAll(userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()));
        if(null == roleIds || roleIds.size() == 0)
            return null;
        Example roleExample = new Example(Role.class);
        roleExample.createCriteria().andIn("id", roleIds).andEqualTo("state", DefaultStateEnum.ENABLED.getValue());
        List<Role> roles = roleMapper.selectByExample(roleExample);
        if(null == roles || roles.size() == 0)
            throw new SPIException(BasicEcode.DATA_ERROR);
        for(Role r : roles){
            if(StringUtils.isNotEmpty(r.getPidList())){
                String[] pidList = r.getPidList().split(",");
                for(String pid: pidList){
                    roleIds.add(Integer.parseInt(pid));
                }
            }
            roleIds.add(r.getId());
        }
        roleExample.clear();
        roleExample.createCriteria().andIn("id", roleIds);
        return roles;
    }

    @Override
    public int deleteRole(Integer id) {
        RolePrivilege rolePrivQuery = new RolePrivilege();
        rolePrivQuery.setRoleId(id);
        rolePrivilegeMapper.delete(rolePrivQuery);
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Role role, List<RolePrivilege> rolePrivileges) {
        int result = roleMapper.updateByPrimaryKeySelective(role);
        if(result > 0) {
            // 删除
            Example example = new Example(RolePrivilege.class);
            example.createCriteria().andEqualTo("roleId", role.getId());
            rolePrivilegeMapper.deleteByExample(example);
            rolePrivilegeMapper.insertList(rolePrivileges);
        }
        return result;
    }
}