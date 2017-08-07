package com.redding.rbac.commons.pojo.dto;

import com.redding.rbac.commons.utils.validation.Add;
import com.redding.rbac.commons.utils.validation.Add;
import com.redding.rbac.commons.utils.validation.Update;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserEditDto implements Serializable {

    private Integer id;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 更新时间
     */
    private Date updatedDate;

    /**
     * 用户名
     */
    @NotEmpty(groups = {Add.class}, message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(groups = {Add.class},message = "密码不能为空")
    private transient String password;

    /**
     * 账户状态,默认值为1，0=禁用，1=启用
     */
    @Null(groups = {Add.class, Update.class}, message = "账号状态必须为空")
    private Integer state;

    /**
     * 昵称
     */
    @NotEmpty(groups = {Add.class, Update.class},message = "昵称不能为空")
    private String nickName;

    /**
     * 真实姓名
     */
    @NotEmpty(groups = {Add.class, Update.class},message = "真实姓名不能为空")
    private String name;

    /**
     * 邮箱
     */
    @NotEmpty(groups = {Add.class, Update.class}, message = "邮箱不能为空")
    private String email;

    /**
     * 电话
     */
    @NotEmpty(groups = {Add.class, Update.class}, message = "手机号码不能为空")
    private String phone;

    /**
     * 性别,默认值为0. 1=男,2=女,0=未知
     */
    @NotNull(groups = {Add.class, Update.class},message = "性别不能为空")
    private Integer sex;

    /**
     * 企业id
     */
    private Integer enterpriseId;

    /**
     * 用户角色
     */
    private List<Integer> roleIds;

    /**
     * 用户类型
     */
    @NotNull(groups = {Add.class, Update.class},message = "用户类型不能为空")
    private Integer type;

    /**
     * 职位状态
     */
    private Integer postState;

    /**
     * 组织id
     */
    private List<Integer> organizationIds;

}