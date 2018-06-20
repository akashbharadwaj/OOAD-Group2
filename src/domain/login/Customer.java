package domain.login;
/**
 * 
 * @author mehra
 *
 */
public class Customer {

	private String username;
	private String password;
	private String name;
	private int age;
	private String gender;
	private String usertype;
	public void setUserType(String usertype) {
		this.usertype = usertype;
	}
	public String getUserType() {
		return usertype;
	}
	public void setAge(String age) {
		this.age = Integer.parseInt(age);
	}
	public int getAge() {
		return age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return usertype;
	}	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}

