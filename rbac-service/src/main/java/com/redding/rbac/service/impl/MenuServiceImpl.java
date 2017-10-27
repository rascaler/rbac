package com.redding.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.MenuDto;
import com.redding.rbac.commons.pojo.dto.MenuNodeDto;
import com.redding.rbac.commons.pojo.query.MenuQuery;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.commons.utils.PageParams;
import com.redding.rbac.infrastructure.domain.Menu;
import com.redding.rbac.infrastructure.manager.MenuManager;
import com.redding.rbac.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuManager menuManager;

    @Override
    public List<MenuNodeDto> getMenuTree(Integer appId, boolean withOperation) throws SPIException {
        return menuManager.getMenuTree(appId, withOperation);
    }

    @Override
    public PageInfo<MenuDto> pageMenus(MenuQuery query, PageParams pageParams) {
        Example example = new Example(Menu.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNoneEmpty(query.getName()))
            criteria.andLike("name", query.getName() + "%");
        if(StringUtils.isNotEmpty(query.getCode()))
            criteria.andEqualTo("code", query.getCode());
        PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize());
        List<Menu> menus = menuManager.selectByExample(example);
        PageInfo pageInfo = new PageInfo(menus);
        pageInfo.setList(BeanMapper.mapList(menus, MenuDto.class));
        return pageInfo;
    }
}