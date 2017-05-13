package com.redding.rbac.commons.pojo.dto;

import java.io.Serializable;

public class OrganizationUserDto implements Serializable {
    private Integer id;

    private Integer organizationid;

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