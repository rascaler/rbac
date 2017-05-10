package com.redding.rbac.dao.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user")
public class User {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 创建时间
     */
    @Column(name = "createdDate")
    private Date createddate;

    /**
     * 更新时间
     */
    @Column(name = "updatedDate")
    private Date updateddate;

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
    private Byte state;

    /**
     * 昵称
     */
    @Column(name = "nickName")
    private String nickname;

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
    private Byte sex;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取创建时间
     *
     * @return createdDate - 创建时间
     */
    public Date getCreateddate() {
        return createddate;
    }

    /**
     * 设置创建时间
     *
     * @param createddate 创建时间
     */
    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    /**
     * 获取更新时间
     *
     * @return updatedDate - 更新时间
     */
    public Date getUpdateddate() {
        return updateddate;
    }

    /**
     * 设置更新时间
     *
     * @param updateddate 更新时间
     */
    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取账户状态,默认值为1，0=禁用，1=启用
     *
     * @return state - 账户状态,默认值为1，0=禁用，1=启用
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置账户状态,默认值为1，0=禁用，1=启用
     *
     * @param state 账户状态,默认值为1，0=禁用，1=启用
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 获取昵称
     *
     * @return nickName - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取真实姓名
     *
     * @return name - 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实姓名
     *
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取性别,默认值为0. 1=男,2=女,0=未知
     *
     * @return sex - 性别,默认值为0. 1=男,2=女,0=未知
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别,默认值为0. 1=男,2=女,0=未知
     *
     * @param sex 性别,默认值为0. 1=男,2=女,0=未知
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * @return enterpriseId
     */
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * @param enterpriseid
     */
    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }
}