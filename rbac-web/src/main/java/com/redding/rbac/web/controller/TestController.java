package com.redding.rbac.web.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.redding.rbac.web.utils.DateConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
public class TestController {



    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    String testDate(@RequestBody Test test) {
        return "Hello World1!";
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    @ResponseBody
    String test2(Test2 test2) {
        return "Hello World2!";
    }

    @RequestMapping(value = "/test3",method = RequestMethod.POST)
    @ResponseBody
    String test3(Test2 test2) {
        return "Hello World2!";
    }
}

class Test implements Serializable{

    @JsonDeserialize(using = DateJsonDeserializer.class)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
class Test2 implements Serializable{

    @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE_TIME)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

class DateJsonSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator generator, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        om.writeValue(generator, sdf.format(date));
    }

}

/**
 * Desc:日期类型的反序列化类
 *
 * @author zhangwei<wei.zw@corp.netease.com>
 * @since 2015年9月18日 下午4:31:02
 * @version v 0.1
 */
class DateJsonDeserializer extends JsonDeserializer<Date> {

    private String DATE = "yyyy-MM-dd";
    private String DATE_TIME_NO_SECOND = "yyyy-MM-dd HH:mm";
    private String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Date deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        try {
            String pattern = null;
            String origin = parser.getValueAsString();
            if(StringUtils.isEmpty(origin))
                return null;
            String[] temp = origin.split("\\:");
            if(null == temp || temp.length <=1)
                pattern = DATE;
            else if(temp.length == 2)
                pattern = DATE_TIME_NO_SECOND;
            else if(temp.length == 3)
                pattern = DATE_TIME;
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(origin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
