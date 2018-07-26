package domain.arenas;

import java.util.List;

import domain.login.Customer;
import domain.login.Login;

/**
 * 
 * @author mehra
 * The methods that we need to save and retrieve data from the database
 */
public interface ArenaDao {

	/**
	 * 
	 * @param c
	 * @return
	 */
	public int addArena(Arena c);
	public int deleteArena(Arena c);
	public int updateArena(Arena c);
	/*
	 * Retrieve the Customer object from the database
	 */
	//public Customer di(Login login);

	public List<Arena> displayArenas(String s);
	//public Customer getCustomer(String username, String pass); This method does not needed as we have the Login object

	
}

