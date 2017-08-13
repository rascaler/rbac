package com.redding.rbac.service;


import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.PrivilegeDto;

import java.util.List;

public interface PrivilegeService {
    List<PrivilegeDto> getPrivileges(Integer userId) throws SPIException;
}