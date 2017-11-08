package com.redding.rbac.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "tb_menu_privilege")
public class MenuPrivilege {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "menuId")
    private Integer menuId;

    @Column(name = "privilegeId")
    private Integer privilegeId;

    @Column(name = "checkState")
    private Integer checkState;
}