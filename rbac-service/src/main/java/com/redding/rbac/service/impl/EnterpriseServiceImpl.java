package com.redding.rbac.service.impl;

import com.redding.rbac.commons.pojo.dto.EnterpriseDto;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.infrastructure.manager.EnterpriseManager;
import com.redding.rbac.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseManager enterpriseManager;

    @Override
    public EnterpriseDto getById(Integer id){
        return BeanMapper.map(enterpriseManager.selectByKey(1), EnterpriseDto.class);
    }
}