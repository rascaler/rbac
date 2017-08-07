package com.redding.rbac.commons.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrganizationNodeDto implements Serializable {

    /**
     * 组织id
     */
    private Integer id;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 更新时间
     */
    private Date updatedDate;

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

    /////////////////////////////////
    /**
     *
     */
    private List<OrganizationNodeDto> children;
}