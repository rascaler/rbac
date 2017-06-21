package com.redding.rbac.infrastructure.mapper;

import com.redding.rbac.commons.pojo.dto.RoleDto;
import com.redding.rbac.infrastructure.domain.Role;
import com.redding.rbac.infrastructure.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
    List<RoleDto> selectUserRoles(@Param("userId") Integer userId,@Param("enterpriseId") Integer enterpriseId);
}