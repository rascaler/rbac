package com.redding.rbac.commons.pojo.dto.auth;

import com.redding.rbac.commons.pojo.dto.RoleDto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserAuthDto implements Serializable {
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
    private String username;

    /**
     * 密码
     */
    private transient String password;

    /**
     * 账户状态,默认值为1，0=禁用，1=启用
     */
    private Integer state;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 性别,默认值为0. 1=男,2=女,0=未知
     */
    private Integer sex;

    private Integer enterpriseId;

    private List<RoleAuthDto> roles;

}