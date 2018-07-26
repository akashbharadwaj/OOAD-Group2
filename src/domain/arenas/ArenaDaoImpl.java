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
	public int addArena(Arena a) {
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("Select * from arenas where name=? and location=?");
			ps.setString(2, a.getLocation());
			ps.setString(1, a.getName());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				status = 1;
			}
			if(status==0)
			{
				ps =conn.prepareStatement("insert into arenas (name,location) values(?,?)");
				//ps.setString(1, a.setarenaID(arenaID));
				ps.setString(2, a.getLocation());
				ps.setString(1, a.getName());
				status = ps.executeUpdate();
				System.out.println(status);
				status = 0;
			}
			
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	@Override
	public int deleteArena(Arena a) {
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("Select * from arenas where name=? and location=?");
			ps.setString(2, a.getLocation());
			ps.setString(1, a.getName());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				status = 1;
			}
			if(status==1)
			{
				ps =conn.prepareStatement("delete from arenas where name = ? and location = ?");
				//ps.setString(1, a.setarenaID(arenaID));
				System.out.println(a.getLocation() +" "+ a.getName());
				ps.setString(2, a.getLocation());
				ps.setString(1, a.getName());
				status = ps.executeUpdate();
			}
			
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	@Override
	public int updateArena(Arena a) {
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("Select * from arenas where id=?");
			//ps.setString(2, a.getLocation());
			//ps.setString(1, a.getName());
			System.out.println(a.getArenaID());
			ps.setInt(1, a.getArenaID());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				status = 1;
				//int id = rs.getInt(1);
			}
			if(status==1)
			{
				ps =conn.prepareStatement("update arenas set name = ?,location = ? where id=?");
				ps.setInt(3, a.getArenaID());
				ps.setString(2, a.getLocation());
				ps.setString(1, a.getName());
				System.out.println(a.getLocation() +" "+ a.getName());
				status = ps.executeUpdate();
				System.out.println(status);
			}
			
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	@Override
	public List<Arena> displayArenas(String s) {
		List<Arena> arena = new LinkedList<>();
		
	try{
		ResultSet rs;
		
		conn = db.getConnection();
		ps =conn.prepareStatement("select * from arenas where name like ? or location like ?");
		ps.setString(2, "%"+s+"%");
		ps.setString(1, "%"+s+"%");	
		System.out.println(ps);
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
