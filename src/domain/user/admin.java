package domain.user;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;
import domain.login.Customer;
import domain.login.Login;
import notifications.sendMail;

@WebServlet("/admin")
public class admin extends HttpServlet{
	
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	sendMail sm = new sendMail();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c = new Customer();
		sendMail sm = new sendMail();
		System.out.println("preparing to send notification");
		String message = request.getParameter("message");
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select userId from customer");

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				sm.send(rs.getString(1), message);
				//System.out.println(rs.getString(1));
			}
			conn.close();
			request.setAttribute("message", "Email Sent");
			request.getRequestDispatcher("adminPage.jsp").forward(request, response);

		}catch(Exception e){
			System.out.println(e);
		}
	}	
}
