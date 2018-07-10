package domain.arenas;
import domain.arenas.*;
import domain.user.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/ArenaController")
public class ArenaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
    public ArenaController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArenaDao arenaDao = new ArenaDaoImpl();
		Arena ar = new Arena();
		//String username = request.getParameter("username");
		//String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		//Login login = new Login(username, pass);
		//Customer c = customerDao.validateCustomer(login);
		//ArenaController a = new ArenaController();
		//admin adm =  new admin();
		//String rs = "";
		//List<Arena> arenas;

		//arenas = a.displayArenas();
		System.out.println(submitType.equals("add"));
		if(submitType.equals("add")){
			ar.setName(request.getParameter("name"));
			ar.setLocation(request.getParameter("location"));
			
			int status = arenaDao.addArena(ar);
			if(status == 1)
				request.setAttribute("failureMessage", "Arena Add Unsuccessful!");
			else
				request.setAttribute("successMessage", "Arena Added Successfully!");
			request.getRequestDispatcher("adminPage.jsp").forward(request, response);
		}
		else if(submitType.equals("delete")) {
			ar.setName(request.getParameter("name"));
			ar.setLocation(request.getParameter("location"));
			int status = arenaDao.deleteArena(ar);
			if(status == 1)
				request.setAttribute("successMessage", "Arena Deleted Successfully!");
			else
				request.setAttribute("failureMessage", "Arena Delete Unsuccessful!");
			request.getRequestDispatcher("adminPage.jsp").forward(request, response);
		}

	}

}
