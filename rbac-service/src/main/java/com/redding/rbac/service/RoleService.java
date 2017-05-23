package com.redding.rbac.service;


import com.redding.rbac.commons.pojo.dto.RoleDto;

import java.util.List;

public interface RoleService {

    List<RoleDto> getAll(Integer enterpriseId);
}