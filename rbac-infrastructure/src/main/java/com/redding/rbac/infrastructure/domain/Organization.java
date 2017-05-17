package com.redding.rbac.infrastructure.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_organization")
public class Organization {
    @Id
    @Column(name = "id")
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
     * 父节点
     */
    @Column(name = "parentId")
    private Integer parentId;

    /**
     * 父节点ID列表
     */
    @Column(name = "pidList")
    private String pidList;

    /**
     * 组织名称
     */
    @Column(name = "name")
    private String name;

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
     * 获取创建时间
     *
     * @return createdDate - 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置创建时间
     *
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取更新时间
     *
     * @return updatedDate - 更新时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 设置更新时间
     *
     * @param updatedDate 更新时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * 获取父节点
     *
     * @return parentId - 父节点
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父节点
     *
     * @param parentId 父节点
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取父节点ID列表
     *
     * @return pidList - 父节点ID列表
     */
    public String getPidList() {
        return pidList;
    }

    /**
     * 设置父节点ID列表
     *
     * @param pidList 父节点ID列表
     */
    public void setPidList(String pidList) {
        this.pidList = pidList;
    }

    /**
     * 获取组织名称
     *
     * @return name - 组织名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置组织名称
     *
     * @param name 组织名称
     */
    public void setName(String name) {
        this.name = name;
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