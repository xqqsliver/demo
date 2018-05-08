package com.example.demo.spring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * ioc的实现核心
 * 
 * @author ThinkPad
 *
 */
public class IocUtils implements BeanFactory {
	private Map<String, Object> beanMap = new HashMap<String, Object>();

	@Override
	public Object getBean(String beanName) {

		return beanMap.get(beanName);
	}

	public void ClassPathXmlApplicationContext() throws Exception {
		SAXBuilder saxBuilder = new SAXBuilder();
		// 加载整个文档
		Document doc = saxBuilder
				.build("src/main/resources/applicationContext.xml");
		// 加载root
		Element rootElement = doc.getRootElement();
		// 获得所有的bean配置
		List beans = rootElement.getChildren("bean");
		// 轮询所有的bean。挨个获取bean的位置
		for (Object object : beans) {
			Element elem = (Element) object;
			String id = elem.getAttributeValue("id");
			Object o = Class.forName(elem.getAttributeValue("class"))
					.newInstance();
			List propertylist = elem.getChildren("property");
			// 轮询bean下的property的配置，对每个依赖进行注入，此处是调用set方法，
			// 类似于spring3中注入方式的构造方法注入
			for (int i = 0; i < propertylist.size(); i++) {
				Element e = (Element) propertylist.get(i);
				String name = e.getAttributeValue("name");
				String ref = e.getAttributeValue("ref");
				// 获得依赖的bean，准备注入
				Object property = getBean(ref);
				// 调用set方法注入，第一个参数是方法名，第二个参数是执行该方法的具体参数
				// ，此处property.getClass是指参数是个property配置的对象
				Method method = o.getClass().getMethod(
						"set" + name.substring(0, 1).toUpperCase()
								+ name.substring(1), property.getClass());
				// 执行获取的方法，并且传入要执行该方法的的对象O 和要传入的的参数property
				method.invoke(o, property);
			}
			beanMap.put(id, o);// 模拟spring上下文，把所有Bean放入map中。需要的时候就从map中获取

		}
	}

	public static void main(String[] args) throws Exception {
		IocUtils c = new IocUtils();
		c.ClassPathXmlApplicationContext();
		Animal us = (Animal) c.getBean("Animal");
		us.say();

	}
}
