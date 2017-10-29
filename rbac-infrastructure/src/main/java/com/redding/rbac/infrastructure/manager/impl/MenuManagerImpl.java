package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.commons.pojo.dto.MenuNodeDto;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.infrastructure.domain.Menu;
import com.redding.rbac.infrastructure.domain.MenuPrivilege;
import com.redding.rbac.infrastructure.manager.MenuManager;
import com.redding.rbac.infrastructure.mapper.MenuMapper;
import com.redding.rbac.infrastructure.mapper.MenuPrivilegeMapper;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuManagerImpl extends DefaultManager<Menu> implements MenuManager {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuPrivilegeMapper menuPrivilegeMapper;

    @Override
    public List<MenuNodeDto> getMenuTree(Integer appId, boolean withOperation) {
        Menu query = new Menu();
        query.setAppId(appId);
        if(!withOperation)
            query.setType(0);
        List<Menu> menus = menuMapper.select(query);
        if(null == menus || menus.size() == 0)
            return null;
        List<MenuNodeDto> roots = BeanMapper.mapList(menus.stream().filter(m -> m.getParentId().equals(0))
                .collect(Collectors.toList()), MenuNodeDto.class);
        if(null == roots || roots.size() == 0)
            return null;
        roots.forEach(r -> recurMenu(r, menus));
        return roots;
    }

    @Override
    public int removeMenu(Integer id) {
        MenuPrivilege query = new MenuPrivilege();
        query.setMenuId(id);
        menuPrivilegeMapper.delete(query);
        int result = menuMapper.deleteByPrimaryKey(id);
        return result;
    }

    private void recurMenu(MenuNodeDto parent, List<Menu> all){
        if(parent.getType() == 1)
            return;
        List<Menu> children = all.stream().filter(m -> m.getParentId().equals(parent.getId())).collect(Collectors.toList());
        if(null == children || children.size() == 0)
            return;
        List<MenuNodeDto> nodes = new ArrayList<MenuNodeDto>();
        children.forEach(c ->{
            MenuNodeDto node = BeanMapper.map(c, MenuNodeDto.class);
            if(c.getType() == 1){
                recurMenu(node, all);
            }
            nodes.add(node);
        });
        parent.setChildren(nodes);
    }
}