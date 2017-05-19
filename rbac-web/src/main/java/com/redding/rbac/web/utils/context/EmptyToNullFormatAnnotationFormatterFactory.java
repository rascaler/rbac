package com.redding.rbac.web.utils.context;

import com.redding.rbac.commons.utils.annotation.EmptyToNullFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.EmbeddedValueResolutionSupport;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.text.ParseException;
import java.util.*;

public class EmptyToNullFormatAnnotationFormatterFactory extends EmbeddedValueResolutionSupport
        implements AnnotationFormatterFactory<EmptyToNullFormat> {


    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> clazz = new HashSet<Class<?>>();
        clazz.add(String.class);
        return clazz;
    }

    @Override
    public Printer<String> getPrinter(EmptyToNullFormat emptyToNullFormat, Class<?> aClass) {
        return this.configureFormatterFrom(emptyToNullFormat);
    }

    @Override
    public Parser<String> getParser(EmptyToNullFormat emptyToNullFormat, Class<?> aClass) {
        return this.configureFormatterFrom(emptyToNullFormat);
    }
    private Formatter<String> configureFormatterFrom(EmptyToNullFormat annotation) {
        return new Formatter<String>() {
            @Override
            public String parse(String s, Locale locale) throws ParseException {
                if(StringUtils.isEmpty(s))
                    return null;
                else
                    return s;
            }

            @Override
            public String print(String s, Locale locale) {
                if(StringUtils.isEmpty(s))
                    return null;
                else
                    return s;
            }
        };
    }
}