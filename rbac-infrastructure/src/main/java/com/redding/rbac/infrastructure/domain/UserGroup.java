package com.redding.rbac.infrastructure.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_group")
public class UserGroup {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;

    /**
     * 组名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 父用户组id
     */
    @Column(name = "parentId")
    private Integer parentId;

    /**
     * 父用户组id列表
     */
    @Column(name = "pidList")
    private String pidList;

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
     * 获取组名称
     *
     * @return name - 组名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置组名称
     *
     * @param name 组名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父用户组id
     *
     * @return parentId - 父用户组id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父用户组id
     *
     * @param parentId 父用户组id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取父用户组id列表
     *
     * @return pidList - 父用户组id列表
     */
    public String getPidList() {
        return pidList;
    }

    /**
     * 设置父用户组id列表
     *
     * @param pidList 父用户组id列表
     */
    public void setPidList(String pidList) {
        this.pidList = pidList;
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