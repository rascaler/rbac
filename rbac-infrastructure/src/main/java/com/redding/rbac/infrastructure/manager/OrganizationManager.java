package com.redding.rbac.infrastructure.manager;

import com.redding.rbac.commons.pojo.dto.OrganizationNodeDto;
import com.redding.rbac.infrastructure.domain.Organization;
import com.redding.rbac.infrastructure.utils.BaseManager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationManager extends BaseManager<Organization> {
    List<Organization> querySelfAndSub(Integer id, Integer enterpriseId);
}