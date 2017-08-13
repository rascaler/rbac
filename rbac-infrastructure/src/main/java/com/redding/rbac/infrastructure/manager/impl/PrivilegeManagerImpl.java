package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.Privilege;
import com.redding.rbac.infrastructure.manager.PrivilegeManager;
import com.redding.rbac.infrastructure.mapper.PrivilegeMapper;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilegeManagerImpl extends DefaultManager<Privilege> implements PrivilegeManager {

    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Override
    public List<Privilege> getPrivileges(List<Integer> roleIds) {
        return privilegeMapper.selectPrivilegesByRoleIds(roleIds);
    }
}