package com.wangsong.commons.util;



import org.springframework.beans.BeansException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;


public class SpringContextUtil  {  
	public static WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();    
	public static Object getBean(String name) throws BeansException {  	
		return webApplicationContext.getBean(name);
    }  
  
}