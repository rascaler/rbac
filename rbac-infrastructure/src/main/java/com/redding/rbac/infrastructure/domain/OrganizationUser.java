package com.redding.rbac.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "tb_organization_user")
@Getter
@Setter
public class OrganizationUser {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "organizationId")
    private Integer organizationId;

    @Column(name = "userId")
    private Integer userId;
}