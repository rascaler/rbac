package com.redding.rbac.dao.domain;

import javax.persistence.*;

@Table(name = "tb_role_user_group")
public class RoleUserGroup {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "userGroupId")
    private Integer usergroupid;

    @Column(name = "roleId")
    private Integer roleid;

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
    public Integer getUsergroupid() {
        return usergroupid;
    }

    /**
     * @param usergroupid
     */
    public void setUsergroupid(Integer usergroupid) {
        this.usergroupid = usergroupid;
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
}