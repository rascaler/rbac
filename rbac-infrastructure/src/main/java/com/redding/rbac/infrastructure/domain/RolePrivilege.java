package com.redding.rbac.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_role_privilege")
public class RolePrivilege {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "roleId")
    private Integer roleId;

    @Column(name = "privilegeId")
    private Integer privilegeId;

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

    /**
     * @return privilegeId
     */
    public Integer getPrivilegeId() {
        return privilegeId;
    }

    /**
     * @param privilegeId
     */
    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }
}