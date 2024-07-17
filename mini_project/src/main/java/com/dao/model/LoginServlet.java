package com.dao.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String url="jdbc:mysql://localhost:3306/mini_project";
		String un="root";
		String pw="root";
		String retrieve="select password,email from  mini_project.login";
		String p="",em="";
		
//		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,pw,un);
			System.out.println(email+" "+password);
			ResultSet r=con.createStatement().executeQuery(retrieve);
			while(r.next()) {
				p=r.getString("password");em=r.getString("email");
				if(email.equals(em) && password.equals(p)) {
					resp.getWriter().print("done");
				}
				else {
					
				}
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
}
}
