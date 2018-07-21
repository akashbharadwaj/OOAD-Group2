package domain.booking;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import db.DbManager;
import domain.login.Customer;
import notifications.sendMail;



public class BookingDao  {


	
	public List<Integer> getAvailableSlots(int arenaID)  {
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();		
		List<Integer> li = new LinkedList<>();
		HashMap<Integer,Integer> hm = new HashMap<>(); 
		
		try{
			conn = db.getConnection();
			ps = conn.prepareStatement("select slotTime from booking where arenaId = ?");
			ps.setString(1, arenaID+"");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				hm.put(Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(1)));
				
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		for(int i=9;i<17;i++) {
			if(!hm.containsKey(i)) {
				li.add(i);
			}
		}
		return li;
	}
	
	public void submitBooking(int Aid, String Uid, int timeSlot) {
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();	
		sendMail sm = new sendMail();
		int status = 0;
		String arenaName = "";
		try{
			conn = db.getConnection();
			ps = conn.prepareStatement("select name from arenas where id = ?");
			ps.setString(1, Aid+"");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				arenaName = rs.getString(1);
				
			}
			
			ps =conn.prepareStatement("insert into booking (userId,arenaId, arenaName, slotTime) values(?,?,?,?)");
			ps.setString(1, Uid);
			ps.setString(2, Aid+"");
			ps.setString(3, arenaName+"");
			ps.setString(4, timeSlot+"");
			status = ps.executeUpdate();
			conn.close();
			sm.send(Uid, "Booking confirmed for Arena " +arenaName+ " for Time "+ timeSlot +":00 - "+(timeSlot+1) +":00");

		}catch(Exception e){
			System.out.println(e);
		}
		
	}	
	
	public List<Booking> viewBooking( String Uid) {
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();		
		List<Booking> li = new LinkedList<>();
		
		try{
			conn = db.getConnection();
			ps = conn.prepareStatement("select * from booking where userId = ?");
			ps.setString(1, Uid);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				li.add(new Booking(Integer.parseInt(rs.getString(1)),rs.getString(2),Integer.parseInt(rs.getString(3)),rs.getString(4),Integer.parseInt(rs.getString(5))));
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return li;
		
	}
	
	public void cancelBooking( String Bid) {
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();		
				
		try{
			conn = db.getConnection();
			ps = conn.prepareStatement("delete from booking where bookingId = ?");
			ps.setString(1, Bid);
			boolean rs = ps.execute();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	

}
