package com.redding.rbac.commons.pojo.dto;

import java.io.Serializable;

public class RolePrivilegeDto implements Serializable {
    private Integer id;

    private Integer roleid;

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