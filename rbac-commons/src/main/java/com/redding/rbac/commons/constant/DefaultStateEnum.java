package com.redding.rbac.commons.constant;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/6/21 17:39
 */
public enum DefaultStateEnum {

    ENABLED(1,"启用"),
    DISABLED(0,"禁用");

    private int value;

    private String description;

    DefaultStateEnum(int value, String description){
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
