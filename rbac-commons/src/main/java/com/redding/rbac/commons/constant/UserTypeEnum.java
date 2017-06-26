package com.redding.rbac.commons.constant;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/6/21 17:39
 */
public enum UserTypeEnum {

    USER(0,"用户"),
    MANAGER(1,"管理员"),
    USER_AND_MANAGER(2,"用户兼管理员");

    private int value;

    private String description;

    UserTypeEnum(int value, String description){
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
