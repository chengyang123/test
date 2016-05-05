package com.dubbo.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapTest {
	public static void main(String[] args) {
		ConcurrentMap<String,String> map = new ConcurrentHashMap<>();
		/**
		 * 如果不存在key对应的值，则将value以key加入Map，否则返回key对应的旧值
		 * 返回结果:
		 * null
		 * value
		 */
		String res = map.putIfAbsent("key", "value");
		System.out.println(res);
		
		res = map.putIfAbsent("key", "value");
		System.out.println(res);
		
		String aa = "aa";
		aa += "bb";
		
		System.out.println(aa);
		int i = 0;
		i = i++ + ++i;
		System.out.println(i);
	}
}
