package com.redding.rbac.commons.pojo.dto;

import java.io.Serializable;
import java.util.Date;

public class RoleDto implements Serializable {
    private Integer id;

    private Date createddate;

    private Date updateddate;

    private String name;

    /**
     * 角色状态，默认值1，0=禁用，1=启用
     */
    private Byte state;

    private String description;

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
     * @return createdDate
     */
    public Date getCreateddate() {
        return createddate;
    }

    /**
     * @param createddate
     */
    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    /**
     * @return updatedDate
     */
    public Date getUpdateddate() {
        return updateddate;
    }

    /**
     * @param updateddate
     */
    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
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