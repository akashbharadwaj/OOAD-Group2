package domain.arenas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import db.DbManager;

public class Arena {
	public int arenaID;
	public String name;
	public String location;
	
	public Arena() {
		// TODO Auto-generated constructor stub
	}
	public Arena(int arenaID, String name, String location) {
		this.arenaID = arenaID;
		this.name = name;
		this.location = location;
		
	}
	
	public int getArenaID() {
		return this.arenaID;
	}
	public String getName() {
		return this.name;
	}
	public String getLocation() {
		return this.location;
	}
	public void setArenaID(int arenaID) {
		//return this.arenaID;
		this.arenaID = arenaID;
	}
	public void setName(String name) {
		//return this.name;
		this.name = name;
	}
	public void setLocation(String location) {
		//return this.location;
		this.location = location;
	}
}
