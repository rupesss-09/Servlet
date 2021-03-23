package com.example.demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

@WebServlet("/login")
public class Login extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {

		// 1.2.3.4
		if(req.getRemoteAddr() == "1.2.3.4")
			return;

		String uid = req.getParameter("userid");
		String pwd = req.getParameter("password");
		System.out.println( req.getQueryString() );
		try {
			if(uid.equals("john") && pwd.equals("123"))
			{
				res.getWriter().write(" login is successful "); // text format response
				/*
				req.getSession().setAttribute("login", "success");
				res.sendRedirect("welcome.html");
				*/
			}
			else {
				byte[] b="login failed".getBytes();
				res.getOutputStream().write(b); // binary format response
				/*
				req.getSession().setAttribute("login", "failed");
				req.getRequestDispatcher("error.jsp").forward(req, res);
				*/
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
