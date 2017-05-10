package com.redding.rbac.commons.pojo.dto;

import java.io.Serializable;

public class OperationPrivilegeDto implements Serializable {
    private Integer id;

    private Integer operationid;

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
     * @return operationId
     */
    public Integer getOperationid() {
        return operationid;
    }

    /**
     * @param operationid
     */
    public void setOperationid(Integer operationid) {
        this.operationid = operationid;
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