package domain.arenas;

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
//import notifications.sendMail;

@WebServlet("/admin/addArena")
public class AddArenas extends HttpServlet{
	
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	//sendMail sm = new sendMail();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c = new Customer();
		//sendMail sm = new sendMail();
		
		String arenaName = request.getParameter("name");
		String arenaLocation = request.getParameter("location");
		try{
			conn = db.getConnection();
			//ps =conn.prepareStatement("insert into arenas (name,location) values ();");
			ps =conn.prepareStatement("insert into arenas (name,location) values(?,?)");
			ps.setString(1, arenaName);
			ps.setString(2, arenaLocation);
			ps.executeQuery();
			
			conn.close();
			request.setAttribute("message", "Email Sent");
			request.getRequestDispatcher("adminPage.jsp").forward(request, response);

		}catch(Exception e){
			System.out.println(e);
		}
	}	
}


