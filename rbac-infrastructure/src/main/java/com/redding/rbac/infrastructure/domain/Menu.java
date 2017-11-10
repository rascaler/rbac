package com.redding.rbac.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@Table(name = "tb_menu")
public class Menu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;

    @Column(name = "enterpriseId")
    private Integer enterpriseId;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "appId")
    private Integer appId;

    @Column(name = "url")
    private String url;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private Integer type;

    @Column(name = "parentId")
    private Integer parentId;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;

    @Column(name = "level")
    private Integer level;
}