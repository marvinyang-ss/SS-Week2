package com.ss.web.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/index.html").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String correctEmail = "email@email.com";
		String correctPassword = "password123";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		// Check if email and password are correct
		if (email.equals(correctEmail) && password.equals(correctPassword)) {
			pw.print("Success!");
		} else {
			pw.print("Failure!<br><br>");
			
			// Just adding this here for debugging
			// Return the correct email and password
			if (!email.equals(correctEmail)) {
				pw.print("The correct email is '" + correctEmail + "'<br>");
				pw.print("You entered '" + email + "'<br><br>");
			}
			if (!password.equals(correctPassword)) {
				pw.print("The correct password is '" + correctPassword + "'<br>");
				pw.print("You entered '" + password + "'");
			}
		}
	}

}
