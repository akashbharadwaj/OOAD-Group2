package domain.arenas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import db.DbManager;

public class ArenaController {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	
	ResultSet rs;
	String str;
	public List<Arena> displayArenas() {
		List<Arena> arena = new LinkedList<>();
		
	try{
		conn = db.getConnection();
		ps =conn.prepareStatement("select * from arenas");
		rs = ps.executeQuery();
		while(rs.next())
		{
			arena.add(new Arena(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3)));
		}
		conn.close();
	}catch(Exception e){
		System.out.println(e);
	}
	return arena;
	
	}
}
