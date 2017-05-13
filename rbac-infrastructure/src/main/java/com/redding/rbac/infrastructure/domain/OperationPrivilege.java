package com.redding.rbac.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_operation_privilege")
public class OperationPrivilege {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "operationId")
    private Integer operationid;

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