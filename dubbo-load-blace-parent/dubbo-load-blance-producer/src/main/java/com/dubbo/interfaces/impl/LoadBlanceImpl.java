package com.dubbo.interfaces.impl;

import java.util.Properties;

import com.dubbo.interfaces.LoadBlanceInterface;

public class LoadBlanceImpl implements LoadBlanceInterface{

	@Override
	public String LoadBlanceTest(String name) {
		Properties props=System.getProperties();  
		return "hello"+name+props.getProperty("os.name");
	}

}
