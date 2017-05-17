package com.redding.rbac.commons.pojo.dto;

import java.io.Serializable;

public class RoleUserGroupDto implements Serializable {
    private Integer id;

    private Integer userGroupId;

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