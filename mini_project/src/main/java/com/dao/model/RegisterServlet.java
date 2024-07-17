package com.dao.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		
		String url="jdbc:mysql://localhost:3306/mini_project";
		String un="root";
		String pw="root";
		String add="insert into mini_project.registration(`name`,`email`,`password`,`role`) values(?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,pw,un);
		PreparedStatement st = con.prepareStatement(add);
		st.setString(1,name);st.setString(2,email);st.setString(3,password);st.setString(4,role);
		st.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
