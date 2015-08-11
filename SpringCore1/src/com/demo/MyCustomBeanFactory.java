package com.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyCustomBeanFactory  implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
	
		System.out.println("This is the first method going to call after application context being initilized..");
		
	}
}
