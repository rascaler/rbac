package com.redding.rbac.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "tb_organization_role")
@Setter
@Getter
public class OrganizationRole {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 组织id
     */
    @Column(name = "organizationId")
    private Integer organizationId;

    @Column(name = "roleId")
    private Integer roleId;
}