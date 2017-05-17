package com.redding.rbac.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_role_user_group")
public class RoleUserGroup {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "userGroupId")
    private Integer userGroupId;

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
     * @return userGroupId
     */
    public Integer getUserGroupId() {
        return userGroupId;
    }

    /**
     * @param userGroupId
     */
    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
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