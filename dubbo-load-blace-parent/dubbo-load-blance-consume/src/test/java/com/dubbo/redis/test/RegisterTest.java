package com.dubbo.redis.test;

import java.lang.reflect.Method;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.dubbo.interfaces.LoadBlanceInterface;

public class RegisterTest {

	public static void main(String[] args) {
		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("yyy");
		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setProtocol("zookeeper");
		registry.setAddress("139.129.25.214:2181");
		
		// 引用远程服务
		ReferenceConfig<LoadBlanceInterface> reference = new ReferenceConfig<LoadBlanceInterface>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
		reference.setApplication(application);
		reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
		reference.setInterface(LoadBlanceInterface.class);
		
		 
		// 和本地bean一样使用xxxService
		LoadBlanceInterface lbi = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
		Class<? extends LoadBlanceInterface> clazz = lbi.getClass();
		System.out.println(clazz);
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println("=======================================================");
		for (Method method : methods) {
			System.out.println(method);
		}
		String loadBlanceTest = lbi.LoadBlanceTest("周晨阳");
		System.out.println(loadBlanceTest);
	}
}
