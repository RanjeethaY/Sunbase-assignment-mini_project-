package com.dao.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	InputStream inputStream =null;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		 Part filePart = request.getPart("file");
		 String contentType = filePart.getContentType();
	inputStream= filePart.getInputStream();
		 service(request, response);
		    }
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/mini_project";
		String un="root";
		String pw="root";
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String date=req.getParameter("date");
		String add="insert into admin(`title`,`content`,`type`,`uploaded_date`) values(?,?,?,?)";
		resp.setContentType("text/html");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,pw,un);
		PreparedStatement st = con.prepareStatement(add);
		st.setString(1,title);
		st.setString(2,content);
            st.setBlob(3,inputStream);	        
          st.setString(4,date);
		st.executeUpdate();
	        resp.getWriter().print("message");
	}
	catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	}
}
