package domain.arenas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import db.DbManager;



public class ArenaDaoImpl implements ArenaDao{

	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	@Override
	public void addArena(Arena a) {
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("insert into arenas (name,location) values(?,?)");
			//ps.setString(1, a.setarenaID(arenaID));
			ps.setString(1, a.getLocation());
			ps.setString(2, a.getName());
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		//return status;
	}
	@Override
	public void deleteArena(Arena a) {
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("delete from arenas where name = ? and location = ?");
			//ps.setString(1, a.setarenaID(arenaID));
			System.out.println(a.getLocation() +" "+ a.getName());
			ps.setString(2, a.getLocation());
			ps.setString(1, a.getName());
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		//return status;
	}
	@Override
	public List<Arena> displayArenas() {
		List<Arena> arena = new LinkedList<>();
		
	try{
		ResultSet rs;
		
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
