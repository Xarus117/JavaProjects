import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Writer {

	public static boolean write(Account userAccount) {

		ArrayList<String> accounts = Reader.read("src/Assets/Accounts.txt");

		Boolean checkRep = false;

		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter("src/Assets/Accounts.txt"));

			// For each
			for (String account : accounts) {

				// Comprobar que los datos se repiten, es decir, el usuario está haciendo un
				// ingreso
				if (account.startsWith(userAccount.getIban() + "," + userAccount.getAccount_name() + ","
						+ userAccount.getHeadline())) {

					// Editar línea del .txt
					writer.write(userAccount.getAll() + "\n");
					// Seteamos el boleano a verdadero
					checkRep = true;

					// Añadir línea al .txt
				} else {
					writer.write(account + "\n");
				}

			}

			// Si se ha editado alguna línea, no se añadirá una nueva, ya que ha
			// complementado otra
			if (!checkRep) {
				writer.write(userAccount.getAll() + "\n");
			}

			// Cerramos escritor
			writer.close();
			Main.accounts = Reader.read("src/Assets/Accounts.txt");
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean registerUser() {

		ArrayList<String> users = Reader.read("src/Assets/Users.txt");

		boolean checkError = false;
		User User = new User(null, null, null, null, null, null, null);
		Scanner input = new Scanner(System.in);
		while (!checkError) {
			try {
				System.out.println("Número de identificación:");
				String IDHolder = input.nextLine();
				if (IDHolder.length() == 9 && !Character.isDigit(IDHolder.charAt(0))
						|| Character.isDigit(IDHolder.charAt(0)) && !Character.isDigit(IDHolder.charAt(8))) {
					User.setID(IDHolder);
					checkError = true;
				} else {
					System.out.println("Valor invalido, vuelve a intentarlo:");
					checkError = false;
				}
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
		while (!checkError) {
			try {
				System.out.println("Contraseña:");
				User.setPassword(input.nextLine());
				// Hacer filtro para prohibir ","
			} catch (InputMismatchException e) {
				input.nextLine();
			}
		}
		checkError = false;

		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter("src/Assets/Users.txt"));

			// For each
			for (String user : users) {
				if (user.startsWith(User.ID) || user.endsWith(User.email + "," + User.password)) {
					checkError = true;
				}
				writer.write(user + "\n");
			}

			if (!checkError) {
				writer.write(User.ID + "," + User.firstName + "," + User.lastName + "," + User.dateOfBirth + ","
						+ User.address + "," + User.email + "," + User.password + "\n");
			}

			writer.close();
			Main.users = Reader.read("src/Assets/Users.txt");
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static void RegisterAccount(User user) {
		boolean checkError = false;
		Scanner input = new Scanner(System.in);
		Account account = new Account();
		Random rand = new Random();
		String IDHolder = "";
		do {
			checkError = false;
			try {
				IDHolder = "ES912100041845020005" + (rand.nextInt(8999) + 1001);
				for (String userAccount : Main.accounts) {
					if (userAccount.startsWith(IDHolder + ",")) {
						checkError = true;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Valor invalido, vuelve a intentarlo:");
				input.nextLine();
			}
		} while (checkError);

		checkError = false;

		while (!checkError) {
			try {
				System.out.println("Nombre de la cuenta:");
				account.setAccount_name(input.nextLine());
				checkError = true;
			} catch (InputMismatchException e) {
				System.out.println("Valor invalido, vuelve a intentarlo:");
				input.nextLine();
			}
		}

		account.setIban(IDHolder);
		account.setDeposit(0);
		account.setBanking_entity("BBVA");
		account.setHeadline(user.getID());
		write(account);
	}
}