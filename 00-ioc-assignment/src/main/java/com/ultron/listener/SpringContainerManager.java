package com.ultron.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.GenericXmlApplicationContext;

@WebListener
public class SpringContainerManager implements ServletContextListener {

	private GenericXmlApplicationContext springContex;
	private static final String CONFIG = "classpath:/application.xml";
	public static final String SPRING_CONTEX = "spring.contex";

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// Initialized IoC Container
		System.out.println("IOC initialized.... !");

		// set IoC container into Application
		springContex = new GenericXmlApplicationContext(CONFIG);
		sce.getServletContext().setAttribute(SPRING_CONTEX, springContex);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
 System.out.println("Destroy IoC.... !");
		// Close to IoC Container
		if (null != springContex) {
			springContex.close();
		}
	}

}
