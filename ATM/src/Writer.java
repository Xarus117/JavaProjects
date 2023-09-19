import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	        
	        //For each
	        for (String account : accounts) {
	        	
	        	//Comprobar que los datos se repiten, es decir, el usuario está haciendo un ingreso
	        	if (account.startsWith(userAccount.getIban() + "," + userAccount.getAccount_name() + "," + userAccount.getHeadline())) {
	        		
	        		//Editar línea del .txt
	        		writer.write(userAccount.getAll() + "\n");
	        		//Seteamos el boleano a verdadero
	        		checkRep = true;
	        		
	        	//Añadir línea al .txt
	        	} else { writer.write(account+"\n"); }
	        	
	        }
	        
	        //Si se ha editado alguna línea, no se añadirá una nueva, ya que ha complementado otra
	        if (!checkRep) { writer.write(userAccount.getAll()+"\n"); }
	        
	        Main.accounts = Reader.read("src/Assets/Accounts.txt");
	        //Cerramos escritor
	        return true;
	        
	    } catch (IOException e) { e.printStackTrace(); return false; }
	
	}
	
	public static boolean register() {
				
		ArrayList<String> users = Reader.read("src/Assets/Users.txt");

		User regist = User.registerUser();	
		
		Boolean checkError = false;
		
		try {
			
	        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Assets/Users.txt"));
	        
	        //For each
	        for (String user : users) {
	        	if (user.startsWith(regist.ID) || user.endsWith(regist.email+","+regist.password)) {
	        		checkError = true;
	        	}
		        	writer.write(user+"\n");	        	
	        }

			if (!checkError) {
				writer.write(regist.ID+","+regist.firstName+","+regist.lastName+","+regist.dateOfBirth+","+regist.address+","+regist.email+","+regist.password+"\n");
			}

			Main.users = Reader.read("src/Assets/Users.txt");
	        return true;
	        
	    } catch (IOException e) { e.printStackTrace(); return false; }
		
	}
	
	public static void RegisterAccount (User user) {
		boolean checkError = false;
		Scanner input = new Scanner(System.in);
		Account account = new Account();
		Random rand = new Random();
		do {
			checkError = false;
			try {
				String IDHolder = "ES91210004184502000513" + (rand.nextInt(88) + 11);
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
		
		account.setDeposit(0);
		account.setBanking_entity("BBVA");
		account.setHeadline(user.getID());
		write(account);
	}
}