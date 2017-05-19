package com.redding.rbac.commons.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/5/18 8:59
 */
public class BasePoJo implements Serializable{
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
