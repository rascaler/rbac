package com.redding.rbac.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "tb_role_privilege")
@Getter
@Setter
public class RolePrivilege {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "roleId")
    private Integer roleId;

    @Column(name = "privilegeId")
    private Integer privilegeId;
}