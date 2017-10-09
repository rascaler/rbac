package com.redding.rbac.service;

import com.redding.rbac.commons.pojo.dto.AppDto;

import java.util.List;

public interface AppService {
    List<AppDto> getAll();
}