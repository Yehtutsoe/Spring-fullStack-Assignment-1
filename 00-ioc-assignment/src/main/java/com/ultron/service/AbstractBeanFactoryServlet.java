package com.ultron.service;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.BeanFactory;

import com.ultron.listener.SpringContainerManager;

public abstract class AbstractBeanFactoryServlet extends HttpServlet implements BeansFactory {

	private static final long serialVersionUID = 1L;

	@Override
	public <T> T getBean(String name, Class<T> type) {

		var springContex = getServletContext().getAttribute(SpringContainerManager.SPRING_CONTEX);

		if (null != springContex && springContex instanceof BeanFactory factory) {
			return factory.getBean(name, type);
		}
		return null;
	}

}
