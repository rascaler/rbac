package com.redding.rbac.commons.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrganizationEditDto implements Serializable {

    private Integer id;

    /**
     * 父节点
     */
    private Integer parentId;

    /**
     * 父节点ID列表
     */
    private String pidList;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 企业id
     */
    private Integer enterpriseId;

    /**
     * 描述
     */
    private String description;

    /**
     * 组织角色
     */
    private List<Integer> roleIds;

}