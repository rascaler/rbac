package com.redding.rbac.commons.pojo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrganizationEditDto implements Serializable {

    private Integer id;

    /**
     * 父节点
     */
    private Integer parentId;

    /**
     * 父节点ID列表
     */
    private String pidList;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 企业id
     */
    private Integer enterpriseId;

    /**
     * 组织角色
     */
    private List<Integer> roleIds;

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
     * 获取父节点
     *
     * @return parentId - 父节点
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父节点
     *
     * @param parentId 父节点
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取父节点ID列表
     *
     * @return pidList - 父节点ID列表
     */
    public String getPidList() {
        return pidList;
    }

    /**
     * 设置父节点ID列表
     *
     * @param pidList 父节点ID列表
     */
    public void setPidList(String pidList) {
        this.pidList = pidList;
    }

    /**
     * 获取组织名称
     *
     * @return name - 组织名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置组织名称
     *
     * @param name 组织名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return enterpriseId
     */
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * @param enterpriseId
     */
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }
}