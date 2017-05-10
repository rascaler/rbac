package com.redding.rbac.dao.domain;

import javax.persistence.*;

@Table(name = "tb_menu_privilege")
public class MenuPrivilege {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "menuId")
    private Integer menuid;

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