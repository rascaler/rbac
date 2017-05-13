package com.redding.rbac.service;


import com.redding.rbac.commons.pojo.dto.EnterpriseDto;

public interface EnterpriseService {
    EnterpriseDto getById(Integer id);
}