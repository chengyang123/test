package com.dubbo.redis.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	private static final Pattern NAME_SEPARATOR = Pattern.compile("\\s*[,]+\\s*");
	
	
	public static void main(String[] args) {
		String tt = ",,1,,";
		Matcher matcher = NAME_SEPARATOR.matcher(tt);
		boolean matches = matcher.matches();
		System.out.println(matches);
	}
}
