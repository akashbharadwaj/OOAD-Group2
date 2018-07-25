package domain.booking;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;
import domain.arenas.*;
//import domain.arenas.ArenaController;

/**
 * Servlet implementation class Login
 */
@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	BookingDao bd = new BookingDao();
	ArenaDao a = new ArenaDaoImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("show").equals("2")) {
			
			bd.cancelBooking(request.getParameter("Bid"));
			request.setAttribute("message1", "Booking cancelled succesfully");
			List<Arena> arenas = a.displayArenas("");
			request.setAttribute("arenas",arenas);
			request.setAttribute("user", request.getParameter("Uid"));
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			
		}else
		if(request.getParameter("show").equals("1")) {
			List<Booking> bookings = bd.viewBooking(request.getParameter("Uid"));
			request.setAttribute("bookings",bookings);
			request.setAttribute("user", request.getParameter("Uid"));
			request.setAttribute("arena", request.getParameter("Aid"));
			request.getRequestDispatcher("BookingHistory.jsp").forward(request, response);

		}else {
			System.out.println(request.getParameter("Aid"));
			List<Integer> li ;
			li =bd.getAvailableSlots(Integer.parseInt(request.getParameter("Aid")));
			request.setAttribute("li",li);
			request.setAttribute("user", request.getParameter("Uid"));
			request.setAttribute("arena", request.getParameter("Aid"));
			request.getRequestDispatcher("BookingSlot.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int timeslot = Integer.parseInt(request.getParameter("timeslot"));
		String Uid = request.getParameter("Uid");
		int Aid = Integer.parseInt(request.getParameter("Aid"));
		bd.submitBooking(Aid, Uid, timeslot);
		request.setAttribute("message1", "Congratulations!! Your Arena has been booked");
		List<Arena> arenas = a.displayArenas("");
		request.setAttribute("arenas",arenas);
		request.setAttribute("user", request.getParameter("Uid"));
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
		
		
	}	

}
