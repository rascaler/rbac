package com.redding.rbac.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_role_privilege")
public class RolePrivilege {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "roleId")
    private Integer roleid;

    @Column(name = "privilegeId")
    private Integer privilegeid;

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
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * @return privilegeId
     */
    public Integer getPrivilegeid() {
        return privilegeid;
    }

    /**
     * @param privilegeid
     */
    public void setPrivilegeid(Integer privilegeid) {
        this.privilegeid = privilegeid;
    }
}