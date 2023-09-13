import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

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
		this.address = address;
		this.email = email;
	}

	// GETTERS

	public String getID() {
		return ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
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

	// REGISTER

	public static User registerUser() {
		boolean checkError = false;
		User User = new User(null, null, null, null, null, null);
		Scanner input = new Scanner(System.in);
		while (!checkError) {
			try {
				System.out.println("Número de identificación:");
				User.setID(input.nextLine());
				checkError = true;
			} catch (InputMismatchException e) {
				System.out.println("Valor invalido, vuelve a intentarlo:");
				input.nextLine();
			}
		}
		checkError = false;
		while (!checkError) {
			try {
				System.out.println("Nombre:");
				User.setFirstName(input.nextLine());
				checkError = true;
			} catch (InputMismatchException e) {
				System.out.println("Valor invalido, vuelve a intentarlo:");
				input.nextLine();
			}
		}
		checkError = false;
		while (!checkError) {
			try {
				System.out.println("Apellido(s):");
				User.setLastName(input.nextLine());
				checkError = true;
			} catch (InputMismatchException e) {
				System.out.println("Valor invalido, vuelve a intentarlo:");
				input.nextLine();
			}
		}
		checkError = false;
		while (!checkError) {
			try {
				System.out.println("Fecha de nacimiento (formato AÑO-MES-DÍA):");
				String DateHolder = input.nextLine();
				if (DateHolder.indexOf('-') != 4 && DateHolder.lastIndexOf('-') != -1) {
					checkError = false;
					System.out.println("Formato de fecha incorrecto");
				} else {
					User.setDateOfBirth(Date.valueOf(DateHolder));
					checkError = true;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Valor invalido, vuelve a intentarlo:");
			}
		}

		checkError = false;
		while (!checkError) {
			try {
				System.out.println("Localidad / Dirección:");
				User.setAddress(input.nextLine());
				checkError = true;
			} catch (InputMismatchException e) {
				System.out.println("Valor invalido, vuelve a intentarlo:");
				input.nextLine();
			}
		}
		checkError = false;
		while (!checkError) {
			try {
				System.out.println("Correo electrónico:");
				User.setEmail(input.nextLine());
				if (User.getEmail().indexOf('@') == -1) {
					System.out.println("Tienes que introducir un correo electrónico válido, vuelva a intentarlo:");
					checkError = false;
				} else {
					checkError = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Valor invalido, vuelve a intentarlo:");
				input.nextLine();
			}
		}
		checkError = false;
		return User;
	}

}
