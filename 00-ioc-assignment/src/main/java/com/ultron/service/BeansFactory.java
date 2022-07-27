package com.ultron.service;

public interface BeansFactory {

	<T> T getBean(String name, Class<T> requiredType);

}
