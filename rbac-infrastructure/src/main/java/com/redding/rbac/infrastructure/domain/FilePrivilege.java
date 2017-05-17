package com.redding.rbac.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_file_privilege")
public class FilePrivilege {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "fileId")
    private Integer fileId;

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
     * @return fileId
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * @param fileId
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
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