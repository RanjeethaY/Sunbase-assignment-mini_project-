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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String url="jdbc:mysql://localhost:3306/mini_project";
	String un="root";
	String pw="root";
	String delete="delete from admin where title=?";
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,pw,un);
	PreparedStatement st = con.prepareStatement(delete);
st.setString(1,req.getParameter("delete"));
	st.executeUpdate();

}
catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
}
	}}
