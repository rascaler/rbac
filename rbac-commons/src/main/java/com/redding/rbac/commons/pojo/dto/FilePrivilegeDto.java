package com.redding.rbac.commons.pojo.dto;

import java.io.Serializable;

public class FilePrivilegeDto implements Serializable {
    private Integer id;

    private Integer fileId;

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