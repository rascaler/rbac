package com.redding.rbac.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "tb_user_role")
@Setter
@Getter
public class UserRole {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "roleId")
    private Integer roleId;
}