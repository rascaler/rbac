package com.redding.rbac.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_role")
@Setter
@Getter
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;

    @Column(name = "name")
    private String name;

    /**
     * 角色状态，默认值1，0=禁用，1=启用
     */
    @Column(name = "state")
    private Integer state;

    @Column(name = "description")
    private String description;

    @Column(name = "enterpriseId")
    private Integer enterpriseId;

    @Column(name = "parentId")
    private Integer parentId;

    @Column(name = "pidList")
    private String pidList;
}