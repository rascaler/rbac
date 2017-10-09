package com.redding.rbac.commons.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class OperationDto implements Serializable {
    private Integer id;

    private Date createdDate;

    private Date updatedDate;

//    private Integer enterpriseId;

    private String name;

    private Integer appId;

    private Integer menuId;
}