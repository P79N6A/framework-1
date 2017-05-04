package com.framework.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

/**
 * 
 * <p> BeanUtils.java.</p>
 * <p>Description: 用于处理Java 类对象的反射工具方法集合类 .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Mar 18, 2014: 9:41:34 AM
 */
public class BeanUtils {

	protected static final Log logger = LogFactory.getLog(BeanUtils.class);

	private BeanUtils() {
	}

	/**
	 * 循环向上转型,获取对象的DeclaredField.
	 *
	 * @throws NoSuchFieldException
	 *             如果没有该Field时抛出.
	 */
	public static Field getDeclaredField(Object object, String propertyName)
			throws NoSuchFieldException {
		Assert.notNull(object);
		Assert.hasText(propertyName);
		return getDeclaredField(object.getClass(), propertyName);
	}

	/**
	 * 循环向上转型,获取对象的DeclaredField.
	 *
	 * @throws NoSuchFieldException
	 *             如果没有该Field时抛出.
	 */
	public static Field getDeclaredField(Class<?> clazz, String propertyName)
			throws NoSuchFieldException {
		Assert.notNull(clazz);
		Assert.hasText(propertyName);
		for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass
				.getSuperclass()) {

			try {
				return superClass.getDeclaredField(propertyName);
			} catch (NoSuchFieldException e) {
				// Field不在当前类定义,继续向上转型
			}
		}
		throw new NoSuchFieldException("No such field: " + clazz.getName()
				+ '.' + propertyName);
	}

	/**
	 * 暴力获取对象变量值,忽略private,protected修饰符的限制.
	 *
	 * @throws NoSuchFieldException
	 *             如果没有该Field时抛出.
	 */
	public static Object forceGetProperty(Object object, String propertyName)
			throws NoSuchFieldException {
		Assert.notNull(object);
		Assert.hasText(propertyName);

		Field field = getDeclaredField(object, propertyName);

		boolean accessible = field.isAccessible();
		field.setAccessible(true);

		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			logger.info("error wont' happen");
		}
		field.setAccessible(accessible);
		return result;
	}

	/**
	 * 暴力设置对象变量值,忽略private,protected修饰符的限制.
	 *
	 * @throws NoSuchFieldException
	 *             如果没有该Field时抛出.
	 */
	public static void forceSetProperty(Object object, String propertyName,
			Object newValue) throws NoSuchFieldException {
		Assert.notNull(object);
		Assert.hasText(propertyName);

		Field field = getDeclaredField(object, propertyName);
		boolean accessible = field.isAccessible();
		field.setAccessible(true);
		try {
			field.set(object, newValue);
		} catch (IllegalAccessException e) {
			logger.info("Error won't happen");
		}
		field.setAccessible(accessible);
	}

	/**
	 * 暴力调用对象函数，忽略private,protected修饰符的限制。
	 *
	 * @throws NoSuchMethodException
	 *             如果没有该Method时抛出.
	 */
	public static Object invokePrivateMethod(Object object, String methodName,Object... params) throws NoSuchMethodException {
		Assert.notNull(object);
		Assert.hasText(methodName);
		Class<?>[] types = new Class[params.length];
		for (int i = 0; i < params.length; i++) {
			types[i] = params[i].getClass();
		}

		Class<?> clazz = object.getClass();
		Method method = null;
		for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				method = superClass.getDeclaredMethod(methodName, types);
				break;
			} catch (NoSuchMethodException e) {
				// 方法不在当前类定义,继续向上转型
			}
		}

		if (method == null)
			throw new NoSuchMethodException("No Such Method:"
					+ clazz.getSimpleName() + methodName);

		boolean accessible = method.isAccessible();
		method.setAccessible(true);
		Object result = null;
		try {
			result = method.invoke(object, params);
		} catch (Exception e) {
			ReflectionUtils.handleReflectionException(e);
		}
		method.setAccessible(accessible);
		return result;
	}

	/**
	 * 按Filed的类型取得Field列表.
	 */
	public static List<Field> getFieldsByType(Object object, Class<?> type) {
		List<Field> list = new ArrayList<Field>();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.getType().isAssignableFrom(type)) {
				list.add(field);
			}
		}
		return list;
	}

	/**
	 * 按FiledName获得Field的类型.
	 */
	public static Class<?> getPropertyType(Class<?> type, String name)
			throws NoSuchFieldException {
		return getDeclaredField(type, name).getType();
	}

	/**
	 * 获得field的getter函数名称.
	 */
	public static String getGetterName(Class<?> type, String fieldName) {
		Assert.notNull(type, "Type required");
		Assert.hasText(fieldName, "FieldName required");

		if (type.getName().equals("boolean")) {
			return "is" + StringUtils.capitalize(fieldName);
		} else {
			return "get" + StringUtils.capitalize(fieldName);
		}
	}

	/**
	 * 获得field的getter函数,如果找不到该方法,返回null.
	 */
	public static Method getGetterMethod(Class<?> type, String fieldName) {
		try {
			return type.getMethod(getGetterName(type, fieldName));
		} catch (NoSuchMethodException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * bean属性复制
	 * @param dest 目的
	 * @param orig 源
	 * @return
	 */
	public static final Object copyProperties(Object dest, Object orig) {
		ConvertUtils.register(new DoubleConverter(null), Double.class);
		ConvertUtils.register(new FloatConverter(null), Float.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new LongConverter(null), Long.class);
		ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
		if (orig != null) {
			try {
				org.apache.commons.beanutils.BeanUtils.copyProperties(dest, orig);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			dest = null;
		}
		return dest;
	}

	/**
	 * Bean属性复制，如果源对象的属性值为空，此方法会将空值复制到目标对象的相应属性上。
	 *
	 * @param dest 目标对象
	 * @param origi 源对象
	 */
	public static void copyPropertysWithNull(Object dest,Object origi){
		ConvertUtils.register(new DoubleConverter(null), Double.class);
		ConvertUtils.register(new FloatConverter(null), Float.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new LongConverter(null), Long.class);
		PropertyDescriptor[] destDescriptors=PropertyUtils.getPropertyDescriptors(dest);
	    PropertyDescriptor[] origiDescriptors=PropertyUtils.getPropertyDescriptors(origi);
	    List<String> origiPropertyNames=new ArrayList<String>();
	    for (int i=0; i<origiDescriptors.length; i++) {
	      origiPropertyNames.add(origiDescriptors[i].getName());
	    }
	    for (int i=0; i<destDescriptors.length; i++) {
	        PropertyDescriptor destProperty=destDescriptors[i];
	        String name=destProperty.getName();

	        try {
	            if (origiPropertyNames.contains(name)) {
	                Object value=PropertyUtils.getSimpleProperty(origi,name);
	                PropertyUtils.setSimpleProperty(dest,name,value);
	            }
	        }
	        catch (Exception ex) {
//	        	ex.printStackTrace();
	        }
	    }
	}
	/**
	 * Bean属性复制，如果源对象的属性值为" 非空"，此方法会将空值复制到目标对象的相应属性上
	 * @param dest
	 * @param origi
	 */
	public static void copyPropertysWithoutNull(Object dest,Object origi)
	{
		ConvertUtils.register(new DoubleConverter(null), Double.class);
		ConvertUtils.register(new FloatConverter(null), Float.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new LongConverter(null), Long.class);
		PropertyDescriptor[] destDescriptors=PropertyUtils.getPropertyDescriptors(dest);
	    PropertyDescriptor[] origiDescriptors=PropertyUtils.getPropertyDescriptors(origi);
	    List<String> origiPropertyNames=new ArrayList<String>();
	    for (int i=0; i<origiDescriptors.length; i++) {
	      origiPropertyNames.add(origiDescriptors[i].getName());
	    }
	    for (int i=0; i<destDescriptors.length; i++) {
	        PropertyDescriptor destProperty=destDescriptors[i];
	        String name=destProperty.getName();

	        try {
	            if (origiPropertyNames.contains(name)) {
	                Object value=PropertyUtils.getSimpleProperty(origi,name);
	                if(value!=null)//只复制非空值
	                	PropertyUtils.setSimpleProperty(dest,name,value);
	            }
	        }
	        catch (Exception ex) {
//	        	ex.printStackTrace();
	        }
	    }
	}
	/**
	 * 根据属性名和值在beanList中查找bean的位置,未找到时返回-1
	 * @param beanList list of bean
	 * @param propertyName 属性
	 * @param value 值
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static int findInList(List<?> beanList,String propertyName,Object value) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
	  for(int i=0;i<beanList.size();i++){
	    Object bean = beanList.get(i);
	    Object tmpValue = PropertyUtils.getProperty(bean,propertyName);
	    if (tmpValue == null){
	      if(value==null){
	        return i;
	      }
	    }else if(tmpValue.equals(value)){
	      return i;
	    }
	  }
	  return -1;
	}
  /**
   * 根据属性名和值在beanList中查找bean,未找到时返回null
   * @param beanList list of bean
   * @param propertyName 属性
   * @param value 值
   * @return
   * @throws NoSuchMethodException
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   */
  public static Object findBean(List<?> beanList,String propertyName,Object value) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
    for(int i=0;i<beanList.size();i++){
      Object bean = beanList.get(i);
      Object tmpValue = PropertyUtils.getProperty(bean,propertyName);
      if (tmpValue == null){
        if(value==null){
          return bean;
        }
      }else if(tmpValue.equals(value)){
        return bean;
      }
    }
    return null;
  }
  /**
   * 根据属性名和值在Collection中查找bean,未找到时返回null
   * @param collection Collection of bean
   * @param propertyName 属性
   * @param value 值
   * @return Object
   * @throws NoSuchMethodException
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   */
  public static Object findBean(Collection<?> collection,String propertyName,Object value) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
    for(Object bean : collection){
      Object tmpValue = PropertyUtils.getProperty(bean,propertyName);
      if (tmpValue == null){
        if(value==null){
          return bean;
        }
      }else if(tmpValue.equals(value)){
        return bean;
      }
    }
    return null;
  }

//  /**
//   * 判断string是否在集合中，只对Set<String>有效
//   * @return
//   */
//  public static boolean isStringInSet(Set<String> set, String string) {
//    boolean isIn=false;
//    for (String tmp : set) {
//      if (com.syswin.crm.framework.common.util.StringUtils.equalsWithNull(tmp,string)) {
//        isIn=true;
//        return isIn;
//      }
//    }
//    return isIn;
//  }
  /**
   * 判断Object是否在集合中，只对实现了equals方法的类有效
   * @return
   */
  public static boolean isObjectInSet(Set<Object> set, Object object) {
    boolean isIn=false;
    for (Object tmp : set) {
      if (object==null) {
        if (tmp==null) {
          return true;
        }
      }
      else if (tmp.equals(object)) {
        isIn=true;
        return isIn;
      }
    }
    return isIn;
  }

  /**
   * 根据属性名和值在Collection中查找bean,未找到时返回null
   * @param collection Collection of bean
   * @param propertyName 属性
   * @param value 值
   * @return Object
   * @throws NoSuchMethodException
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   */
  public static Object findBean(Collection<?> collection,String[] propertyNameArray,Object[] valueArray) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
	  for(Object bean : collection){
		  boolean isEqual=true;
		  for(int i=0;i<propertyNameArray.length;i++){
			  String propertyName = propertyNameArray[i];
			  Object value = valueArray[i];

		      Object tmpValue = PropertyUtils.getProperty(bean,propertyName);
		      if (tmpValue == null){
		        if(value==null){
		          continue;
		        }else{
		          isEqual=false;
		          break;
		        }
		      }else if(tmpValue.equals(value)){
		        continue;
		      }else{
		    	  isEqual=false;
		    	  break;
		      }
		  }
		  if (isEqual){
			  return bean;
		  }
	}
	return null;
  }

}