package com.redding.rbac.commons.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class RoleDto implements Serializable {
    private Integer id;

    private Date createdDate;

    private Date updatedDate;

    private String name;

    /**
     * 角色状态，默认值1，0=禁用，1=启用
     */
    private Integer state;

    private String description;

    private Integer enterpriseId;

    private Integer parentId;

    private String pidList;

}