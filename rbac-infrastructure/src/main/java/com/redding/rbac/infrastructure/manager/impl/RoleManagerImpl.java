package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.commons.pojo.dto.RoleDto;
import com.redding.rbac.infrastructure.domain.Role;
import com.redding.rbac.infrastructure.domain.RolePrivilege;
import com.redding.rbac.infrastructure.manager.RoleManager;
import com.redding.rbac.infrastructure.mapper.RoleMapper;
import com.redding.rbac.infrastructure.mapper.RolePrivilegeMapper;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RoleManagerImpl extends DefaultManager<Role> implements RoleManager {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePrivilegeMapper rolePrivilegeMapper;

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