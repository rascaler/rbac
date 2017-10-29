package com.redding.rbac.service;


import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.PrivilegeDto;
import com.redding.rbac.commons.pojo.dto.PrivilegeEditDto;
import com.redding.rbac.commons.pojo.query.PrivilegeQuery;
import com.redding.rbac.commons.utils.PageParams;

import java.util.List;

public interface PrivilegeService {
    List<PrivilegeDto> getPrivileges(Integer userId) throws SPIException;

    PageInfo<PrivilegeDto> pagePrivileges(PageParams pageParams, PrivilegeQuery query);

    int save(PrivilegeEditDto privilegeEditDto);

    int update(PrivilegeEditDto privilegeEditDto);

    int delete(Integer id);
}