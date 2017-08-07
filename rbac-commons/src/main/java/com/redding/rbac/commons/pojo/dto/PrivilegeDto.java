package com.redding.rbac.commons.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PrivilegeDto implements Serializable {
    private Integer id;

    private String name;

    private Date createdDate;

    private Date updatedDate;

    private Integer enterpriseId;
}