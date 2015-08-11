package com.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor  implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {

		System.out.println("BeanPostProcessor :: Before initlizing bean "+beanName +"  Bean object "+bean);
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
	
		System.out.println("BeanPostProcessor :: After initlizing bean "+beanName +"  Bean object "+bean);
		
		
		return bean;
	}

}
