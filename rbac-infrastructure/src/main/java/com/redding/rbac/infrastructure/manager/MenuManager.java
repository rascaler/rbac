package com.redding.rbac.infrastructure.manager;

import com.redding.rbac.commons.pojo.dto.MenuNodeDto;
import com.redding.rbac.infrastructure.domain.Menu;
import com.redding.rbac.infrastructure.utils.BaseManager;

import java.util.List;

public interface MenuManager extends BaseManager<Menu> {
    List<MenuNodeDto> getMenuTree(Integer appId, boolean withOperation);
}