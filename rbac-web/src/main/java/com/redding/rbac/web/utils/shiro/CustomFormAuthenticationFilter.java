package com.redding.rbac.web.utils.shiro;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.web.config.ShiroConfig;
import com.redding.rbac.web.utils.bean.OuterResult;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        // 这里也要开启跨域
        if(ShiroConfig.corsEnable) {
            httpServletResponse.setHeader("Access-Control-Allow-Credentials","true");
            httpServletResponse.setHeader("Access-Control-Allow-Origin",httpServletRequest.getHeader("Origin"));
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write(JSON.toJSONString(new OuterResult(BasicEcode.USER_ERR_UNLOGINED, "您尚未登录或登录时间过长,请重新登录!"), SerializerFeature.WriteMapNullValue));
        return false;
    }

    /**
     * 判断ajax请求
     * @param request
     * @return
     */
    boolean isAjax(HttpServletRequest request){
        return  (request.getHeader("x-requested-with") != null  && "vue-resource-request".equals( request.getHeader("x-requested-with").toString())   ) ;
    }
}