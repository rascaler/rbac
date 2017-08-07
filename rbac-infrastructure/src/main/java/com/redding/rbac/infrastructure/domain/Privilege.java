package com.redding.rbac.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_privilege")
@Getter
@Setter
public class Privilege {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;

    @Column(name = "enterpriseId")
    private Integer enterpriseId;
}