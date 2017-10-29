package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.MenuPrivilege;
import com.redding.rbac.infrastructure.domain.Privilege;
import com.redding.rbac.infrastructure.manager.PrivilegeManager;
import com.redding.rbac.infrastructure.mapper.MenuPrivilegeMapper;
import com.redding.rbac.infrastructure.mapper.PrivilegeMapper;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilegeManagerImpl extends DefaultManager<Privilege> implements PrivilegeManager {

    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Autowired
    private MenuPrivilegeMapper menuPrivilegeMapper;

    @Override
    public List<Privilege> getPrivileges(List<Integer> roleIds) {
        return privilegeMapper.selectPrivilegesByRoleIds(roleIds);
    }

    @Override
    public int save(Privilege privilege, List<MenuPrivilege> list) {
        int result = privilegeMapper.insertSelective(privilege);
        list.forEach(l -> l.setPrivilegeId(privilege.getId()));
        menuPrivilegeMapper.insertList(list);
        return result;
    }

    @Override
    public int update(Privilege privilege, List<MenuPrivilege> list) {
        int result = privilegeMapper.updateByPrimaryKey(privilege);
        // 删除原来的权限菜单关联
        MenuPrivilege query = new MenuPrivilege();
        query.setPrivilegeId(privilege.getId());
        menuPrivilegeMapper.delete(query);
        menuPrivilegeMapper.insertList(list);
        return result;
    }

    @Override
    public int deletePrivilege(Integer id) {
        MenuPrivilege query = new MenuPrivilege();
        query.setPrivilegeId(id);
        menuPrivilegeMapper.delete(query);
        return privilegeMapper.deleteByPrimaryKey(id);
    }
}