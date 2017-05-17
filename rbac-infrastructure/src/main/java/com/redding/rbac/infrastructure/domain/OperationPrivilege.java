package com.redding.rbac.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_operation_privilege")
public class OperationPrivilege {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "operationId")
    private Integer operationId;

    @Column(name = "privilegeId")
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