package com.redding.rbac.commons.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.util.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/5/18 10:41
 */
public class BaseQuery implements Serializable{
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

//    public void clearEmpty(){
//        Field[] fields = this.getClass().getDeclaredFields();
//        for (Field f : fields) {
//            //情况
//            if(f.getType().equals(String.class)){
//                f.get
//            }
//            f.setAccessible(true);
//        }
//    }


}
