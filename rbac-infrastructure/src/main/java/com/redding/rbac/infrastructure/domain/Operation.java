package com.redding.rbac.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@Table(name = "tb_operation")
public class Operation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;

//    @Column(name = "enterpriseId")
//    private Integer enterpriseId;
    @Column(name = "menuId")
    private Integer menuId;

    @Column(name = "appId")
    private Integer appId;

    @Column(name = "name")
    private String name;

}