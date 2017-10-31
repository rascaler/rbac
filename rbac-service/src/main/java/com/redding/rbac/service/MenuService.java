package com.redding.rbac.service;


import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.MenuDto;
import com.redding.rbac.commons.pojo.dto.MenuEditDto;
import com.redding.rbac.commons.pojo.dto.MenuNodeDto;
import com.redding.rbac.commons.pojo.query.MenuQuery;
import com.redding.rbac.commons.utils.PageParams;

import java.util.List;

public interface MenuService {
    List<MenuNodeDto> getMenuTree(Integer appId, boolean withOperation) throws SPIException;

    PageInfo<MenuDto> pageMenus(MenuQuery query, PageParams pageParams) throws SPIException;

    MenuEditDto save(MenuEditDto menuEditDto) throws SPIException;

    void removeMenu(Integer id) throws SPIException;

    MenuEditDto getEditDetail(Integer id) throws SPIException;

}