package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.Role;
import com.redding.rbac.infrastructure.manager.RoleManager;
import com.redding.rbac.infrastructure.mapper.RoleMapper;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RoleManagerImpl extends DefaultManager<Role> implements RoleManager {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAll(Integer enterpriseId) {
        Role query = new Role();
        query.setEnterpriseId(enterpriseId);
        return roleMapper.select(query);
    }
}