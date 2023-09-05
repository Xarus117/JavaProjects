import java.util.concurrent.ThreadLocalRandom;

public class User {
	int idUser;
	String firstName;
	String lastName; 
	int age;
	String email;
	int phoneNumber;
	
	
	public User(String firstName, String lastName, int age, String email, int phoneNumber) {
		this.idUser = ThreadLocalRandom.current().nextInt(1, 9999 + 1);
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
}
