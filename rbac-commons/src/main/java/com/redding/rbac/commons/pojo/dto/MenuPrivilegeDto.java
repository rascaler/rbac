package com.redding.rbac.commons.pojo.dto;

import java.io.Serializable;

public class MenuPrivilegeDto implements Serializable {
    private Integer id;

    private Integer menuid;

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
     * @return menuId
     */
    public Integer getMenuid() {
        return menuid;
    }

    /**
     * @param menuid
     */
    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
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