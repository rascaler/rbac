package com.redding.rbac.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_user_user_group")
public class UserUserGroup {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "userGroupId")
    private Integer userGroupId;

    @Column(name = "userId")
    private Integer userId;

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
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}