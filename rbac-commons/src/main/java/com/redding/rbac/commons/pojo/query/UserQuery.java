package com.redding.rbac.commons.pojo.query;

import com.redding.rbac.commons.pojo.BasePoJo;
import com.redding.rbac.commons.utils.annotation.EmptyToNullFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/5/18 8:58
 */
public class UserQuery extends BasePoJo{

    private static final long serialVersionUID = 2125275927365284905L;

    /**
     * 组织id
     */
    private Integer organizationId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 关键词模糊查询
     */
    @EmptyToNullFormat
    private String keyword;

    /**
     * 用户状态
     */
    private Integer state;

    /**
     * 职位状态
     */
    private Integer postState;
    /**
     * 企业id
     */

    private Integer enterpriseId;


    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getPostState() {
        return postState;
    }

    public void setPostState(Integer postState) {
        this.postState = postState;
    }
}
