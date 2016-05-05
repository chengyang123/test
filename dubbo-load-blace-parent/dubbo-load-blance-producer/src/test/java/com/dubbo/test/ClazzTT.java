package com.dubbo.test;

public class ClazzTT {
	public static String[] pns;, public static java.util.Map pts;, public static String[] mns;, public static String[] dmns;, public static Class[] mts0;
	public String run() {
		System.out.println("hello");
		return "hello";
	}

	public String[] getPropertyNames() {
		return pns;
	}

	public boolean hasProperty(String n) {
		return pts.containsKey($1);
	}

	public Class getPropertyType(String n) {
		return (Class) pts.get($1);
	}

	public String[] getMethodNames() {
		return mns;
	}

	public String[] getDeclaredMethodNames() {
		return dmns;
	}

	public void setPropertyValue(Object o, String n, Object v) {
		com.dubbo.interfaces.LoadBlanceInterface w;
		try {
			w = ((com.dubbo.interfaces.LoadBlanceInterface) $1);
		} catch (Throwable e) {
			throw new IllegalArgumentException(e);
		}
		throw new com.alibaba.dubbo.common.bytecode.NoSuchPropertyException(
				"Not found property \""
						+ $2
						+ "\" filed or setter method in class com.dubbo.interfaces.LoadBlanceInterface.");
	}

	public Object getPropertyValue(Object o, String n) {
		com.dubbo.interfaces.LoadBlanceInterface w;
		try {
			w = ((com.dubbo.interfaces.LoadBlanceInterface) $1);
		} catch (Throwable e) {
			throw new IllegalArgumentException(e);
		}
		throw new com.alibaba.dubbo.common.bytecode.NoSuchPropertyException(
				"Not found property \""
						+ $2
						+ "\" filed or setter method in class com.dubbo.interfaces.LoadBlanceInterface.");
	}

	public Object invokeMethod(Object o, String n, Class[] p, Object[] v)
			throws java.lang.reflect.InvocationTargetException {
		com.dubbo.interfaces.LoadBlanceInterface w;
		try {
			w = ((com.dubbo.interfaces.LoadBlanceInterface) $1);
		} catch (Throwable e) {
			throw new IllegalArgumentException(e);
		}
		try {
			if ("LoadBlanceTest".equals($2) && $3.length == 1) {
				return ($w) w.LoadBlanceTest((java.lang.String) $4[0]);
			}
		} catch (Throwable e) {
			throw new java.lang.reflect.InvocationTargetException(e);
		}
		throw new com.alibaba.dubbo.common.bytecode.NoSuchMethodException(
				"Not found method \""
						+ $2
						+ "\" in class com.dubbo.interfaces.LoadBlanceInterface.");
	}
}
