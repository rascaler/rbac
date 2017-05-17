package com.redding.rbac.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_organization_user")
public class OrganizationUser {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "organizationId")
    private Integer organizationId;

    @Column(name = "userId")
    private Integer userId;

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
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * @param organizationId
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}