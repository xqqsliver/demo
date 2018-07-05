package com.example.demo.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.example.demo.aop.HelloWorld;
import com.example.demo.aop.HelloWorldImpl1;

public class DubboProvider {
	public static void main(String args[]) {
		HelloWorld helloWord = new HelloWorldImpl1();
		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("xxx");
		// 连接注册中心
		RegistryConfig config = new RegistryConfig();
		config.setUsername("aa");// 注册中心登陆用户名
		config.setAddress("xxx");// 地址
		config.setPassword("llll");// 密码
		// 服务提供者协议配置
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		protocol.setPort(80);
		protocol.setThreads(1);

		// 服务提供者暴露服务配置
		ServiceConfig<HelloWorld> service = new ServiceConfig<HelloWorld>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
		service.setApplication(application);
		service.setRegistry(config); // 多个注册中心可以用setRegistries()
		service.setProtocol(protocol); // 多个协议可以用setProtocols()
		service.setInterface(HelloWorld.class);
		service.setRef(helloWord);
		service.setVersion("1.0.0");
		// 暴露及注册服务
		service.export();

	}

}
