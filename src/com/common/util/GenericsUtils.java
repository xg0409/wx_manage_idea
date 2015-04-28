package com.common.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.log4j.Logger;

/**
 * GenericsµÄutilÀà. 
 * @author Administrator
 *
 */
public class GenericsUtils {
	
	private static Logger logger = Logger.getLogger(GenericsUtils.class);
	
	
	public static Class getSuperClassGenricType(Class clazz){
		return getSuperClassGenricType(clazz,0);
	}


	public static Class getSuperClassGenricType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();
		
		if(!(genType instanceof ParameterizedType)){
			logger.warn(String.format("%s superclass not ParameterizedType", clazz.getSimpleName()));
			return Object.class;
		}
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		if ((index >= params.length) || (index < 0)) {
			logger.warn(String.format("Index: %s, Size of %s Parameterized Type:%s",index,clazz.getSimpleName(),params.length));

			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			logger.warn(String.format("%s not set the actual class on superclass generic parameter",clazz.getSimpleName()));
			return Object.class;
		}
		return (Class)params[0];
	}
	

}
