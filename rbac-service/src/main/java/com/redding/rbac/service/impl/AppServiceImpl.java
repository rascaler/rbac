package com.redding.rbac.service.impl;

import com.redding.rbac.commons.pojo.dto.AppDto;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.infrastructure.manager.AppManager;
import com.redding.rbac.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppManager appManager;
    @Override
    public List<AppDto> getAll() {
        return BeanMapper.mapList(appManager.selectAll(), AppDto.class);
    }

    @Override
    public AppDto getOne() {
        return null;
    }
}