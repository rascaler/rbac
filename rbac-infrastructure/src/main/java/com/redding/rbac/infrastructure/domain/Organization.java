package com.redding.rbac.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_organization")
@Getter
@Setter
public class Organization {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 创建时间
     */
    @Column(name = "createdDate")
    private Date createdDate;

    /**
     * 更新时间
     */
    @Column(name = "updatedDate")
    private Date updatedDate;

    /**
     * 父节点
     */
    @Column(name = "parentId")
    private Integer parentId;

    /**
     * 父节点ID列表
     */
    @Column(name = "pidList")
    private String pidList;

    /**
     * 组织名称
     */
    @Column(name = "name")
    private String name;

    @Column(name = "enterpriseId")
    private Integer enterpriseId;

    @Column(name = "description")
    private String description;
}