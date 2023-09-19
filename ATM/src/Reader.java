import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
	
	public static ArrayList<String> read(String file) {
		
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            
            //Añadir todas las líneas del .txt en una arraylist
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            
            //Cerrar lector
            reader.close();
        } catch (IOException e) { e.printStackTrace(); }
		
		//Devolver arraylist
		return lines;
	}
	
	public static User login(String[] info) {
	
		for (String user : Main.users) {
			if (user.startsWith(info[0] + ",") && user.endsWith("," + info[1])) {
				User client = new User(user);
				return client;
			}
		}
		
		User noUser = new User();
		return noUser;
	}
	
	public static ArrayList<Account> selectAccount(User user) {
		
		ArrayList<Account> userAccounts = new ArrayList<Account>();
		
		try {
			
            for (String account : Main.accounts) {
            	if (account.contains(user.getID())) {
            		userAccounts.add(new Account(account));
            		
            	}
            }
			
		} catch (Exception e) { System.out.println(e); }
		
		return userAccounts;
		
	}
}
//Hash en la contraseña
