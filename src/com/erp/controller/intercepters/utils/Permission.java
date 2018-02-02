
package com.erp.controller.intercepters.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**    
* 权限配置 注解类 
* @author cui xiao     
*
*/    

@Retention(RetentionPolicy.RUNTIME) 
//注解 的存活时间,整个运行时都存活    
@Target(ElementType.METHOD) 
//此注解表示只能在方法上面有效    

public @interface Permission { 
	
	/** 模块名 ,用来表示在哪个action上进行权限验证，value 是action name**/   
	String actionName();    
	/** 权限值 ,对应数据库中的权限代码 privilege_code**/    
	String privilegeValue();   
}
