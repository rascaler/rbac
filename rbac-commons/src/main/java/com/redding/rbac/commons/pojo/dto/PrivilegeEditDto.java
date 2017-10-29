package com.redding.rbac.commons.pojo.dto;

import com.redding.rbac.commons.utils.validation.Add;
import com.redding.rbac.commons.utils.validation.Update;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PrivilegeEditDto implements Serializable {

    @NotNull(groups = {Update.class})
    private Integer id;

    @NotEmpty(groups = {Add.class, Update.class})
    private String name;

    @NotEmpty(groups = {Add.class, Update.class})
    private String code;

    private Date createdDate;

    private Date updatedDate;

    private Integer enterpriseId;

    @NotNull(groups = {Add.class, Update.class})
    private Integer appId;

    private List<Integer> menuIds;
}