package com.redding.rbac.commons.pojo.dto;

import com.redding.rbac.commons.utils.validation.Add;
import com.redding.rbac.commons.utils.validation.Update;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class MenuEditDto implements Serializable {
    private Integer id;

    private Date createdDate;

    private Date updatedDate;

    private Integer enterpriseId;

    @NotNull(groups = {Add.class, Update.class}, message = "序号不能为空")
    private Integer sequence;

    @NotNull(groups = {Add.class, Update.class}, message = "应用不能为空")
    private Integer appId;

    private String url;

    @NotEmpty(groups = {Add.class, Update.class}, message = "菜单名不能为空")
    private String name;

    @NotNull(groups = {Add.class, Update.class}, message = "菜单类型不能为空")
    private Integer type;

    private Integer parentId;

    private String description;

    @NotEmpty(groups = {Add.class, Update.class}, message = "编码不能为空")
    private String code;

    @NotNull(groups = {Add.class, Update.class}, message = "菜单级别")
    private Integer level;
}