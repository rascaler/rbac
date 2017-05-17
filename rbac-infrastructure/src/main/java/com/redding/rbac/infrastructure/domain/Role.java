package com.redding.rbac.infrastructure.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_role")
public class Role {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;

    @Column(name = "name")
    private String name;

    /**
     * 角色状态，默认值1，0=禁用，1=启用
     */
    @Column(name = "state")
    private Byte state;

    @Column(name = "description")
    private String description;

    @Column(name = "enterpriseId")
    private Integer enterpriseId;

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
     * @return createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return updatedDate
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * @param updatedDate
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色状态，默认值1，0=禁用，1=启用
     *
     * @return state - 角色状态，默认值1，0=禁用，1=启用
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置角色状态，默认值1，0=禁用，1=启用
     *
     * @param state 角色状态，默认值1，0=禁用，1=启用
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return enterpriseId
     */
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * @param enterpriseId
     */
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}