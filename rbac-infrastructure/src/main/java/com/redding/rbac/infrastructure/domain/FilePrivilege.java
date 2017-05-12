package com.redding.rbac.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_file_privilege")
public class FilePrivilege {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "fileId")
    private Integer fileid;

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
     * @return fileId
     */
    public Integer getFileid() {
        return fileid;
    }

    /**
     * @param fileid
     */
    public void setFileid(Integer fileid) {
        this.fileid = fileid;
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