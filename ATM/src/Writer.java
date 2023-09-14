import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
	
	public static void write(String iban, String account_name, String headline, double deposit, String banking_entity) {
		
		//Llamar al lector y que pase arraylist, modificar arraylist y escribirla
		
		ArrayList<String> cuentas = new ArrayList<String>();

		Boolean checkRep = false;
		cuentas = Reader.read("src/Assets/Accounts.txt");
		String data = iban+","+account_name+","+headline+","+deposit+","+banking_entity;
		
		try {
			
	        BufferedWriter escritor = new BufferedWriter(new FileWriter("src/Assets/Accounts.txt"));
	        
	        //For each
	        for (String cuenta : cuentas) {
	        	
	        	if (cuenta.startsWith(iban+","+account_name+","+headline) && cuenta.endsWith(banking_entity)) {
	        		
	        		String[] info = cuenta.split(",");
	        		double total = Double.parseDouble(info[3]) + deposit;
	        		info[3] = ""+total;
	        		escritor.write(info[0]+","+info[1]+","+info[2]+","+info[3]+","+info[4]+"\n");
	        		checkRep = true;
	        		
	        	} else { escritor.write(cuenta+"\n"); }
	        	
	        }
	        
	        if (!checkRep) { escritor.write(data+"\n"); checkRep = false;}
	        
	        	escritor.close();
	        System.out.println("El archivo se ha escrito correctamente.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	}
	
}