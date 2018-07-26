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

//import db.DbManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/ArenaController")
public class ArenaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//static Connection conn;
	//static PreparedStatement ps;
	//DbManager db = new DbManager();
    public ArenaController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArenaDao arenaDao = new ArenaDaoImpl();
		Arena ar = new Arena();
		String submitType = request.getParameter("submit");
		System.out.println(submitType.equals("add"));
		
		ar.setName(request.getParameter("name"));
		ar.setLocation(request.getParameter("location"));
		
		if(submitType.equals("add")){
			
			
			int status = arenaDao.addArena(ar);
			if(status == 1)
				request.setAttribute("failureMessage", "Arena Add Unsuccessful!");
			else
				request.setAttribute("successMessage", "Arena Added Successfully!");
			request.getRequestDispatcher("adminPage.jsp").forward(request, response);
		}
		else if(submitType.equals("delete")) {
			
			int status = arenaDao.deleteArena(ar);
			if(status == 1)
				request.setAttribute("successMessage", "Arena Deleted Successfully!");
			else
				request.setAttribute("failureMessage", "Arena Delete Unsuccessful!");
			request.getRequestDispatcher("adminPage.jsp").forward(request, response);
		}
		else if(submitType.equals("update")) {
			ar.setArenaID(Integer.parseInt(request.getParameter("arenaId")));
			int status = arenaDao.updateArena(ar);
			
			if(status == 1)
				request.setAttribute("successMessage", "Arena Updated Successfully!");
			else
				request.setAttribute("failureMessage", "Arena Update Unsuccessful!");
				
			request.getRequestDispatcher("adminPage.jsp").forward(request, response);
		}
		else if(submitType.equals("search")){
			System.out.println("search"+request.getParameter("Uid")+request.getParameter("searchString"));
			String searchString = request.getParameter("searchString");
			List<Arena> arenas = arenaDao.displayArenas(searchString);
			request.setAttribute("arenas",arenas);
			request.setAttribute("user", request.getParameter("Uid"));
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
	}

}
