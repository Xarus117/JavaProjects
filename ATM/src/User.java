import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

public class User {
	String ID; // DOCUMENTO NACIONAL DE IDENTIFICACIÓN o EXTRANJERO
	String firstName;
	String lastName; 
	Date dateOfBirth;
	String address;
	String email;
	
	
	public User(String ID, String firstName, String lastName, Date age, String address, String email) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = age;
		this.address = 
		this.email = email;
	}
	
	// GETTERS
	
	public String getID()  {
		return ID;
	}
	
	public String getFirstName()  {
		return firstName;
	}
	
	public String getLastName()  {
		return lastName;
	}
	
	public Date getDateOfBirth()  {
		return dateOfBirth;
	}
	
	public String getAddress()  {
		return address;
	}
	
	public String getEmail()  {
		return email;
	}
	
	// SETTERS
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
