package com.redding.rbac.commons.pojo.query;

import com.redding.rbac.commons.pojo.BasePoJo;
import com.redding.rbac.commons.utils.annotation.EmptyToNullFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/5/18 8:58
 */
@Getter
@Setter
public class PrivilegeQuery extends BasePoJo{

    @EmptyToNullFormat
    private String name;

    /**
     * 角色状态
     */
    private String code;

    private Integer enterpriseId;
}
