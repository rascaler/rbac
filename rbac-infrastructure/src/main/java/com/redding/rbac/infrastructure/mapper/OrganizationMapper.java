package com.redding.rbac.infrastructure.mapper;

import com.redding.rbac.infrastructure.domain.Organization;
import com.redding.rbac.infrastructure.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationMapper extends MyMapper<Organization> {
    List<Organization> selectSelfAndSub(@Param("id") Integer id, @Param("enterpriseId") Integer enterpriseId);
}