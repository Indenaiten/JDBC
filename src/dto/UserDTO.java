package dto;

import java.time.LocalDate;

public class UserDTO {
	//ATTRIBUTES
	private int id;
	private String username;
	private String name;
	private String lastname1;
	private String lastname2;
	private LocalDate birthdate;
	private boolean active;
	
	//METHODS
	//CONSTRUCTS
	public UserDTO(){
		
	}

	public UserDTO(String username, String name, String lastname1, String lastname2, LocalDate birthdate,
			boolean active) {
		this.username = username;
		this.name = name;
		this.lastname1 = lastname1;
		this.lastname2 = lastname2;
		this.birthdate = birthdate;
		this.active = active;
	}
	
	public UserDTO(int id, String username, String name, String lastname1, String lastname2, LocalDate birthdate,
			boolean active) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.lastname1 = lastname1;
		this.lastname2 = lastname2;
		this.birthdate = birthdate;
		this.active = active;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname1() {
		return lastname1;
	}

	public void setLastname1(String lastname1) {
		this.lastname1 = lastname1;
	}

	public String getLastname2() {
		return lastname2;
	}

	public void setLastname2(String lastname2) {
		this.lastname2 = lastname2;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", name=" + name + ", lastname1=" + lastname1
				+ ", lastname2=" + lastname2 + ", birthdate=" + birthdate + ", active=" + active + "]";
	}
}
