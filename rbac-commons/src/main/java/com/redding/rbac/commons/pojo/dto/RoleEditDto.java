package com.redding.rbac.commons.pojo.dto;

import com.redding.rbac.commons.utils.validation.Add;
import com.redding.rbac.commons.utils.validation.Update;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RoleEditDto implements Serializable {

    private Integer id;

    /**
     * 角色名
     */
    @NotEmpty(groups = {Add.class, Update.class}, message = "角色名不能为空")
    private String name;

    /**
     * 角色状态，默认值1，0=禁用，1=启用
     */
    @NotEmpty(groups = {Add.class, Update.class}, message = "备注不能为空")
    private String description;

    /**
     * 企业id
     */
    private Integer enterpriseId;

    /**
     * 父级角色
     */
    private Integer parentId;

    /**
     * 权限id
     */
    private List<Integer> privilegeIds;

}