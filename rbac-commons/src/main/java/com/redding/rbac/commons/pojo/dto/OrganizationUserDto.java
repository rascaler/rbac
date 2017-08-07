package com.redding.rbac.commons.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrganizationUserDto implements Serializable {
    private Integer id;

    private Integer organizationId;

    private Integer userId;

}