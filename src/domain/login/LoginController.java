package domain.login;
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
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
    public LoginController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerDao customerDao = new CustomerDaoImpl();
		
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		Login login = new Login(username, pass);
		Customer c = customerDao.validateCustomer(login);
		ArenaDao a = new ArenaDaoImpl();
		admin adm =  new admin();
		String rs = "";
		List<Arena> arenas;

		arenas = a.displayArenas("");
		if(submitType.equals("login") && c!=null && c.getName()!=null){
			request.setAttribute("user",c.getUsername());
			request.setAttribute("message1", "Hello "+c.getName());
			request.setAttribute("arenas",arenas);
			System.out.println(c.getUserType());
			if(c.getUserType().equals("A")) {
				request.setAttribute("message", "Welcome Admin");
				request.getRequestDispatcher("adminPage.jsp").forward(request, response);
			}else			
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else if(submitType.equals("register")){
			c.setName(request.getParameter("name"));
			c.setUsername(request.getParameter("username"));
			c.setPassword(request.getParameter("password"));
			c.setAge(request.getParameter("age"));
			c.setGender(request.getParameter("gender"));
			c.setUserType(request.getParameter("O"));

			try {
			conn = db.getConnection();
			ps = conn.prepareStatement("select * from customer where userId = ?");
			ps.setString(1, c.getUsername());
			
			ResultSet rs1 = ps.executeQuery();
			if(rs1.next()) {
				request.setAttribute("successMessage", "User Already Registed. Please Log in");
				request.getRequestDispatcher("login.jsp").forward(request, response);				
				}
			}catch(Exception e){
				System.out.println(e);
			}
			customerDao.register(c);
			request.setAttribute("successMessage", "Registration done, please login!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Data Not Found! Please register!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

}
