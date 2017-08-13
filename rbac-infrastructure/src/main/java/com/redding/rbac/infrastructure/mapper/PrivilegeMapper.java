package com.redding.rbac.infrastructure.mapper;

import com.redding.rbac.infrastructure.domain.Privilege;
import com.redding.rbac.infrastructure.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrivilegeMapper extends MyMapper<Privilege> {
    List<Privilege> selectPrivilegesByRoleIds(@Param("roleIds") List<Integer> roleIds);
}