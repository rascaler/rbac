package com.redding.rbac.dao.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_menu")
public class Menu {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "createdDate")
    private Date createddate;

    @Column(name = "updatedDate")
    private Date updateddate;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    @Column(name = "sequence")
    private Integer sequence;

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
     * @return createdDate
     */
    public Date getCreateddate() {
        return createddate;
    }

    /**
     * @param createddate
     */
    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    /**
     * @return updatedDate
     */
    public Date getUpdateddate() {
        return updateddate;
    }

    /**
     * @param updateddate
     */
    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
    }

    /**
     * @return enterpriseId
     */
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * @param enterpriseid
     */
    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    /**
     * @return sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * @param sequence
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}