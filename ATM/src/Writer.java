import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
	
	public static void write(String iban, String account_name, String headline, double deposit, String banking_entity) {
				
		ArrayList<String> accounts = Reader.read("src/Assets/Accounts.txt");

		Boolean checkRep = false;
		String data = iban+","+account_name+","+headline+","+deposit+","+banking_entity;
		
		try {
			
	        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Assets/Accounts.txt"));
	        
	        //For each
	        for (String account : accounts) {
	        	
	        	//Comprobar que los datos se repiten, es decir, el usuario está haciendo un ingreso
	        	if (account.startsWith(iban+","+account_name+","+headline) && account.endsWith(banking_entity)) {
	        		
	        		//Editar arraylist para sumar el depósito y el ingreso
	        		String[] info = account.split(",");
	        		double total = Double.parseDouble(info[3]) + deposit;
	        		//Editar línea del .txt
	        		info[3] = ""+total;
	        		writer.write(info[0]+","+info[1]+","+info[2]+","+info[3]+","+info[4]+"\n");
	        		//Seteamos el boleano a verdadero
	        		checkRep = true;
	        		
	        	//Añadir línea al .txt
	        	} else { writer.write(account+"\n"); }
	        	
	        }
	        
	        //Si se ha editado alguna línea, no se añadirá una nueva, ya que ha complementado otra
	        if (!checkRep) { writer.write(data+"\n"); }
	        
	        //Cerramos escritor
	        writer.close();
	        System.out.println("El archivo se ha escrito correctamente.");
	        
	    } catch (IOException e) { e.printStackTrace(); }
	
	}
	
	public static void register() {
				
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

			//Cerramos escritor
	        writer.close();
	        System.out.println("El archivo se ha escrito correctamente.");
	        
	    } catch (IOException e) { e.printStackTrace(); }
		
	}
}