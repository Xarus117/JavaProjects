import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	public static void read() {
		try {
            BufferedReader lector = new BufferedReader(new FileReader("src/Assets/Accounts.txt"));
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	//Guardar en arraylist para luego guardarlo
}
