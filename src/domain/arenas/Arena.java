package domain.arenas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import db.DbManager;

public class Arena {
	public int arenaID;
	public String name;
	public String location;
	
	
	public Arena(int arenaID, String name, String location) {
		this.arenaID = arenaID;
		this.name = name;
		this.location = location;
		
	}
	public int getarenaID() {
		return this.arenaID;
	}
	public String getname() {
		return this.name;
	}
	public String getlocation() {
		return this.location;
	}

}
