package com.redding.rbac.service;


import com.redding.rbac.commons.pojo.dto.MenuDto;
import com.redding.rbac.commons.pojo.dto.MenuNodeDto;

import java.util.List;

public interface MenuService {
    List<MenuNodeDto> getAppMenus(Integer appId);
}