package com.rascaler.rbac.web.context;

/**
 * ClassName: ResponseBodyWrapHandler
 * Function: ${TODO}(这里用一句话描述这个类的作用).
 *
 * Created by wurenqing on 2017/3/20.
 */

import com.rascaler.rbac.web.annotation.OuterResponseBody;
import com.rascaler.rbac.web.bean.OuterResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.io.IOException;
import java.util.List;

/**
 * ResponseBody包装类，返回Result
 * Created by wurenqing on 2015/10/13.
 */
public class ResponseBodyWrapHandler extends RequestResponseBodyMethodProcessor {


    public ResponseBodyWrapHandler(final List<HttpMessageConverter<?>> messageConverters) {
        super(messageConverters);
    }

    public ResponseBodyWrapHandler(final List<HttpMessageConverter<?>> messageConverters, final ContentNegotiationManager contentNegotiationManager) {
        super(messageConverters, contentNegotiationManager);
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return returnType.getMethodAnnotation(OuterResponseBody.class) != null;
    }


    @Override
    public void handleReturnValue(final Object returnValue, final MethodParameter returnType, final ModelAndViewContainer mavContainer, final NativeWebRequest webRequest) throws IOException, HttpMediaTypeNotAcceptableException {
        OuterResult result = new OuterResult();
        result.setData(returnValue);
        super.handleReturnValue(result, returnType, mavContainer, webRequest);
    }
}