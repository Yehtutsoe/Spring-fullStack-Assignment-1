package com.ultron.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ultron.dto.Course;
import com.ultron.dto.OpenClass;
import com.ultron.model.CourseModel;
import com.ultron.model.OpenClassModel;
import com.ultron.service.AbstractBeanFactoryServlet;

@WebServlet(urlPatterns = { "/classes", "/class-edit" })
public class OpenClassServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get Parameter
		var courseId = req.getParameter("courseId");
		
	

			// Find Course
			var courseModel = getBean("courseModel", CourseModel.class);
			var course = courseModel.findById(Integer.parseInt(courseId));
			 req.setAttribute("course", course);
	
		
		var page = switch (req.getServletPath()) {

		case "/classes" -> {

			var model = getBean("openClassModel", OpenClassModel.class);
			req.setAttribute("classes", model.findByCourse(Integer.parseInt(courseId)));
			yield "/classes.jsp";
		}

		default -> "/class-edit.jsp";

		};

		// Forward Process
		getServletContext().getRequestDispatcher(page).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get Parameter
		var courseId = req.getParameter("courseId");
//		System.out.println(courseId);
		var teacher = req.getParameter("teacher");
//		System.out.println(teacher);
		var startDate = req.getParameter("startDate");
//		System.out.println(startDate);

		
		// Create Class Object
		Course c = new Course();
	   c.setId(Integer.parseInt(courseId));
		OpenClass oc = new OpenClass();
		oc.setCourse(c);
		oc.setTeacher(teacher);
		oc.setStartDate(Date.valueOf(startDate).toLocalDate());

		// Save To Database

		getBean("openClassModel", OpenClassModel.class).save(oc);

		// Redirect Process
		
		resp.sendRedirect("/classes?courseId="+courseId);
	}

}
