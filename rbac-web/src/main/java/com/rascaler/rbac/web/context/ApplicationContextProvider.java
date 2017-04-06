package com.rascaler.rbac.web.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取上下文环境
 *
 * Created by wurenqing on 2017/3/20.
 */
public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext context;

	public static ApplicationContext getApplicationContext() {
		return context;
	}

	public static <T> List<T> getBeansByClass(Class<T> c) {
		Map<String, T> map = ApplicationContextProvider.getApplicationContext().getBeansOfType(c);
		List<T> beans = new ArrayList<T>();
		for (Map.Entry<String, T> entry : map.entrySet()) {
			beans.add(entry.getValue());
		}
		return beans;
	}

	public static <T> T getBeanByClass(Class<T> c) {
		Map<String, T> map = ApplicationContextProvider.getApplicationContext().getBeansOfType(c);
		List<T> beans = new ArrayList<T>();
		for (Map.Entry<String, T> entry : map.entrySet()) {
			beans.add(entry.getValue());
		}
		return beans.get(0);
	}

	public static String getProperty(String propertyName) {
		String propertyValue = context.getEnvironment().getProperty(propertyName);
		return propertyValue;
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

}
