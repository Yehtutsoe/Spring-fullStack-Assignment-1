package com.ultron.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ultron.dto.Course;
import com.ultron.model.CourseModel;
import com.ultron.service.AbstractBeanFactoryServlet;

@WebServlet(urlPatterns = { "/", "courses", "course-edit" })
public class CourseServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var page = switch (req.getServletPath()) {

		case "/course-edit" -> "/course-edit.jsp";

		default -> {

			// Load data and set data to request scope
			var model = getBean("courseModel", CourseModel.class);
			req.setAttribute("course", model.getAll());
			yield "/index.jsp";
		}

		};

		// Forward Process
		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get Request Parameter
		var name = req.getParameter("name");
		var fees = req.getParameter("fees");
		var duration = req.getParameter("duration");
		var description = req.getParameter("description");

		// Create Course Object

		Course c = new Course();
		c.setName(name);
		c.setFees(Double.valueOf(fees));
		c.setDuration(Integer.parseInt(duration));
		c.setDescription(description);

		// Save Data to Database

		getBean("courseModel", CourseModel.class).save(c);

		// Redirect Process

		resp.sendRedirect("/");
	}

}
