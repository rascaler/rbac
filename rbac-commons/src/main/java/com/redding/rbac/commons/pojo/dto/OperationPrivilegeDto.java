package com.redding.rbac.commons.pojo.dto;

import java.io.Serializable;

public class OperationPrivilegeDto implements Serializable {
    private Integer id;

    private Integer operationId;

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
     * @return operationId
     */
    public Integer getOperationId() {
        return operationId;
    }

    /**
     * @param operationId
     */
    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
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