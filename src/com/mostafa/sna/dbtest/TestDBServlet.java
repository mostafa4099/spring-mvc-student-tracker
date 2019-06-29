package com.mostafa.sna.dbtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "root";
		String password = "12345";
		String url = "jdbc:mysql://localhost:3306/mostafa";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			
			PrintWriter writer = response.getWriter();
			writer.println("Connecting to Databases... "+url);
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			
			writer.println("Connection Successful!");
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
