package com.redding.rbac.dao.domain;

import javax.persistence.*;

@Table(name = "tb_organization_user")
public class OrganizationUser {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "organizationId")
    private Integer organizationid;

    @Column(name = "userId")
    private Integer userid;

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
     * @return organizationId
     */
    public Integer getOrganizationid() {
        return organizationid;
    }

    /**
     * @param organizationid
     */
    public void setOrganizationid(Integer organizationid) {
        this.organizationid = organizationid;
    }

    /**
     * @return userId
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}