package com.redding.rbac.infrastructure.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_group")
public class UserGroup {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "createdDate")
    private Date createddate;

    @Column(name = "updatedDate")
    private Date updateddate;

    /**
     * 组名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 父用户组id
     */
    @Column(name = "parentId")
    private Integer parentid;

    /**
     * 父用户组id列表
     */
    @Column(name = "pidList")
    private String pidlist;

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
    public Integer getParentid() {
        return parentid;
    }

    /**
     * 设置父用户组id
     *
     * @param parentid 父用户组id
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取父用户组id列表
     *
     * @return pidList - 父用户组id列表
     */
    public String getPidlist() {
        return pidlist;
    }

    /**
     * 设置父用户组id列表
     *
     * @param pidlist 父用户组id列表
     */
    public void setPidlist(String pidlist) {
        this.pidlist = pidlist;
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