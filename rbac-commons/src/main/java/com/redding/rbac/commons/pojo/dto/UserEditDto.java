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
    private String nickName;

    /**
     * 真实姓名
     */
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
     * 获取更新时间
     *
     * @return updatedDate - 更新时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 设置更新时间
     *
     * @param updatedDate 更新时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取账户状态,默认值为1，0=禁用，1=启用
     *
     * @return state - 账户状态,默认值为1，0=禁用，1=启用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置账户状态,默认值为1，0=禁用，1=启用
     *
     * @param state 账户状态,默认值为1，0=禁用，1=启用
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取昵称
     *
     * @return nickName - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取真实姓名
     *
     * @return name - 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实姓名
     *
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取性别,默认值为0. 1=男,2=女,0=未知
     *
     * @return sex - 性别,默认值为0. 1=男,2=女,0=未知
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别,默认值为0. 1=男,2=女,0=未知
     *
     * @param sex 性别,默认值为0. 1=男,2=女,0=未知
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return enterpriseId
     */
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * @param enterpriseId
     */
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPostState() {
        return postState;
    }

    public void setPostState(Integer postState) {
        this.postState = postState;
    }

    public List<Integer> getOrganizationIds() {
        return organizationIds;
    }

    public void setOrganizationIds(List<Integer> organizationIds) {
        this.organizationIds = organizationIds;
    }
}