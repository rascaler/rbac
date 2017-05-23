package com.redding.rbac.service.impl;

import com.redding.rbac.commons.pojo.dto.RoleDto;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.infrastructure.manager.RoleManager;
import com.redding.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleManager roleManager;
    @Override
    public List<RoleDto> getAll(Integer enterpriseId) {
        return BeanMapper.mapList(roleManager.getAll(enterpriseId), RoleDto.class);
    }
}