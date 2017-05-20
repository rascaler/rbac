package com.redding.rbac.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_organization_role")
public class OrganizationRole {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 组织id
     */
    @Column(name = "organizationId")
    private Integer organizationId;

    @Column(name = "roleId")
    private Integer roleId;

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
     * 获取组织id
     *
     * @return organizationId - 组织id
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置组织id
     *
     * @param organizationId 组织id
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * @return roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}