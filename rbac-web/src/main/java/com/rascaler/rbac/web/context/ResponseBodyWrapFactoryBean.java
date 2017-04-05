package com.rascaler.rbac.web.context;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ResponseBodyWrapFactoryBean
 * Function: ${TODO}(这里用一句话描述这个类的作用).
 *
 * @author wurenqing
 * @date: 16/9/11 上午2:51
 */

/**
 * 替换为ResponseBody包装类
 * Created by wurenqing on 2015/10/13.
 */
public class ResponseBodyWrapFactoryBean implements InitializingBean {

    @Autowired
    private RequestMappingHandlerAdapter adapter;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(returnValueHandlers);
        decorateHandlers(handlers);
        adapter.setReturnValueHandlers(handlers);
    }

    private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        
        MappingJackson2HttpMessageConverter converter = ApplicationContextProvider.getBeanByClass(MappingJackson2HttpMessageConverter.class);

        messageConverters.add(converter);

        ResponseBodyWrapHandler handler = new ResponseBodyWrapHandler(messageConverters);
        handlers.add(0, handler);
    }

}