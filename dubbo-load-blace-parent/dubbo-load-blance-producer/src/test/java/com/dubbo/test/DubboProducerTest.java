package com.dubbo.test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.dubbo.interfaces.LoadBlanceInterface;
import com.dubbo.interfaces.impl.LoadBlanceImpl;

public class DubboProducerTest {
	public static void main(String[] args) {
		LoadBlanceInterface lbi = new LoadBlanceImpl();
		 
		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("dubbo-load-blance-server");
		 
		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setProtocol("zookeeper");
		registry.setAddress("139.129.25.214:2181");

		 
		// 服务提供者协议配置
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		protocol.setPort(20880);
		protocol.setThreads(200);
		 
		// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
		 
		// 服务提供者暴露服务配置
		ServiceConfig<LoadBlanceInterface> service = new ServiceConfig<LoadBlanceInterface>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
		service.setApplication(application);
		service.setRegistry(registry); // 多个注册中心可以用setRegistries()
		service.setProtocol(protocol); // 多个协议可以用setProtocols()
		service.setInterface(LoadBlanceInterface.class);
		service.setRef(lbi);
		//service.setVersion("1.0.0");
		// 暴露及注册服务
		service.export();
		
		while(true){}
	}
	
}
