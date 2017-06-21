package com.redding.rbac.commons.pojo.dto;

import java.io.Serializable;
import java.util.Date;

public class RoleDto implements Serializable {
    private Integer id;

    private Date createdDate;

    private Date updatedDate;

    private String name;

    /**
     * 角色状态，默认值1，0=禁用，1=启用
     */
    private Integer state;

    private String description;

    private Integer enterpriseId;

    private Integer parentId;

    private String pidList;

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
    public Integer getState() {
        return state;
    }

    /**
     * 设置角色状态，默认值1，0=禁用，1=启用
     *
     * @param state 角色状态，默认值1，0=禁用，1=启用
     */
    public void setState(Integer state) {
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPidList() {
        return pidList;
    }

    public void setPidList(String pidList) {
        this.pidList = pidList;
    }
}