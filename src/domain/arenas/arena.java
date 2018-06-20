package domain.arenas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import db.DbManager;

public class arena {
	
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	//private static boolean slots[] = new boolean[8];
	//int status = 0;
	ResultSet rs;
	String str;
	public String displayArenas() {
	try{
		conn = db.getConnection();
		ps =conn.prepareStatement("select * from arenas");
		/*
		//ps.setString(1, c.getUsername());
		//ps.setString(2, c.getPassword());
		//ps.setString(3, c.getName());
		ps.setString(4, "10");
		ps.setString(5, "M");
		ps.setString(6, "A");
		*/
		rs = ps.executeQuery();
		//status = ps.executeUpdate();
		
		str = "<table border =1 style = 'margin: 0 auto;'><tr><td>Name</td><td>Location</td><td>Book</td></tr>";
		
		while(rs.next())
		{
			str+= "<tr><td>"+rs.getString(2)+"</td>"
					+ "<td>"+rs.getString(3)+"</td>" 
					+ "<td>"+"<button >Book Arena</button>"+"</td>"
					+ "</tr>";
		}
		
		str+= "</table>";
		
		conn.close();
	}catch(Exception e){
		System.out.println(e);
	}
	return str;
	
	}
}
