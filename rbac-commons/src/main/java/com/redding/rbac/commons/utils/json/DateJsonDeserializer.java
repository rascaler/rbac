package com.redding.rbac.commons.utils.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateJsonDeserializer extends JsonDeserializer<Date> {


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