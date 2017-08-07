package com.redding.rbac.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user")
@Getter
@Setter
public class User {
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
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 账户状态,默认值为1，0=禁用，1=启用
     */
    @Column(name = "state")
    private Integer state;

    /**
     * 昵称
     */
    @Column(name = "nickName")
    private String nickName;

    /**
     * 真实姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 性别,默认值为0. 1=男,2=女,0=未知
     */
    @Column(name = "sex")
    private Integer sex;

    @Column(name = "enterpriseId")
    private Integer enterpriseId;

    @Column(name = "postState")
    private Integer postState;

    @Column(name = "type")
    private Integer type;
}