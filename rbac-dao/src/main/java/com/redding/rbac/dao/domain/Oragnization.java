package com.redding.rbac.dao.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_organization")
public class Oragnization {
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
     * 父节点
     */
    @Column(name = "parentId")
    private Integer parentid;

    /**
     * 父节点ID列表
     */
    @Column(name = "pidList")
    private String pidlist;

    /**
     * 组织名称
     */
    @Column(name = "name")
    private String name;

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
     * 获取父节点
     *
     * @return parentId - 父节点
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * 设置父节点
     *
     * @param parentid 父节点
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取父节点ID列表
     *
     * @return pidList - 父节点ID列表
     */
    public String getPidlist() {
        return pidlist;
    }

    /**
     * 设置父节点ID列表
     *
     * @param pidlist 父节点ID列表
     */
    public void setPidlist(String pidlist) {
        this.pidlist = pidlist;
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