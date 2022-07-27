package com.ultron.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ultron.dto.OpenClass;
import com.ultron.dto.Registration;
import com.ultron.model.OpenClassModel;
import com.ultron.model.RegistrationModel;
import com.ultron.service.AbstractBeanFactoryServlet;

@WebServlet(urlPatterns = { "/registration", "/registration-edit" })
public class RegistrationServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get Parameter
		var classId = req.getParameter("classId");

		// Find class
		var classModel = getBean("openClassModel", OpenClassModel.class);
		var openClass = classModel.findById(Integer.parseInt(classId));
		req.setAttribute("openClass", openClass);

		var page = switch (req.getServletPath()) {

		case "/registration" -> {

			var model = getBean("registrationModel", RegistrationModel.class);
			req.setAttribute("reg", model.findByClass(Integer.parseInt(classId)));
			yield "/registration.jsp";
		}

		default -> "/registration-edit.jsp";

		};

		// Forward Process
		getServletContext().getRequestDispatcher(page).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get parameter
		var classId = req.getParameter("classId");
		var student = req.getParameter("student");
		var phone = req.getParameter("phone");
		var email = req.getParameter("email");

		// Create Registration Object

		OpenClass oc = new OpenClass();
		oc.setId(Integer.parseInt(classId));
		Registration rg = new Registration();
		rg.setOpenClass(oc);
		rg.setStudent(student);
		rg.setPhone(phone);
		rg.setEmail(email);

		// Save To database
		
	     getBean("registrationModel", RegistrationModel.class).save(rg);

		// Redirect Process
	     
	     resp.sendRedirect("/registration?classId="+ classId);

	}
}
