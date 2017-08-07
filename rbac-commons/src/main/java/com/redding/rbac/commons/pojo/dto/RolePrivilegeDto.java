package com.redding.rbac.commons.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RolePrivilegeDto implements Serializable {
    private Integer id;

    private Integer roleId;

    private Integer privilegeId;

}