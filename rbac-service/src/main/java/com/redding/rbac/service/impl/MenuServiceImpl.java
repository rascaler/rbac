package com.redding.rbac.service.impl;

import com.redding.rbac.commons.pojo.dto.MenuNodeDto;
import com.redding.rbac.infrastructure.domain.Menu;
import com.redding.rbac.infrastructure.domain.Operation;
import com.redding.rbac.infrastructure.manager.MenuManager;
import com.redding.rbac.infrastructure.manager.OperationManager;
import com.redding.rbac.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuManager menuManager;

    @Autowired
    private OperationManager operationManager;

    @Override
    public List<MenuNodeDto> getAppMenus(Integer appId) {
        Menu query = new Menu();
        query.setAppId(appId);
        List<Menu> menus = menuManager.selectList(query);
        // 查询操作
        Operation operQuery = new Operation();
        operQuery.setAppId(appId);
        List<Operation> operations = operationManager.selectList(operQuery);
        if(null == menus) return null;
        if(null == operations) {
            menus.forEach(m -> {
            });
        } else {
            menus.forEach(m -> {
                operations.forEach(o -> {

                });
            });
        }
        return null;
    }

}