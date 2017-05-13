package com.redding.rbac.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_user_user_group")
public class UserUserGroup {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "userGroupId")
    private Integer usergroupid;

    @Column(name = "userId")
    private Integer userid;

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
     * @return userId
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}