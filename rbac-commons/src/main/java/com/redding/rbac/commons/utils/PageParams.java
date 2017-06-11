package com.redding.rbac.commons.utils;

import com.redding.rbac.commons.pojo.BasePoJo;

import javax.validation.constraints.NotNull;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/5/18 9:30
 */
public class PageParams extends BasePoJo{

    private static final long serialVersionUID = -2229312585467458453L;
    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空")
    private Integer pageNum;

    /**
     * 每页大小
     */
    @NotNull(message = "每页条数不能为空")
    private Integer pageSize;

    private String orderBy;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
