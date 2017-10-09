package com.redding.rbac.commons.pojo.dto;

import java.io.Serializable;
import java.util.Date;

public class AppDto implements Serializable {
    /**
     * 模块id,使用初始化脚本
     */
    private Integer id;

    /**
     * 模块名称
     */
    private String name;

    /**
     * 模块编码
     */
    private String code;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 修改时间
     */
    private Date updatedDate;

    /**
     * 获取模块id,使用初始化脚本
     *
     * @return id - 模块id,使用初始化脚本
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置模块id,使用初始化脚本
     *
     * @param id 模块id,使用初始化脚本
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取模块名称
     *
     * @return name - 模块名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置模块名称
     *
     * @param name 模块名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取模块编码
     *
     * @return code - 模块编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置模块编码
     *
     * @param code 模块编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取创建时间
     *
     * @return createdDate - 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置创建时间
     *
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取修改时间
     *
     * @return updatedDate - 修改时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 设置修改时间
     *
     * @param updatedDate 修改时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}