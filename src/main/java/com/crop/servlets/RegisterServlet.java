package com.crop.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.crop.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Register servlet");
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String doorNo = request.getParameter("doorNo");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalCode = request.getParameter("postalCode");
        String otherInfo = request.getParameter("otherInfo");
        String size = request.getParameter("size");
        String type = request.getParameter("type");
        String status = request.getParameter("status");
        String location = request.getParameter("location");

        // Add your logic to process the form data (e.g., store in a database)
        
        //register farmer
        // Register address, land then register farmer
        RegisterService registerService = new RegisterService();
        registerService.register(firstName,lastName,username,password,Integer.parseInt(doorNo),street,city,state,postalCode
        		,otherInfo,size,type,status,location);

        // Redirect to a confirmation page or login page
        response.sendRedirect("registrationConfirmation.jsp");
	}

}
