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
        boolean checkRep = false;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Assets/Accounts.txt"));

            for (String account : accounts) {
                if (account.startsWith(userAccount.getIban() + ","
                        + userAccount.getAccount_name() + ","
                        + userAccount.getHeadline())) {
                    writer.write(userAccount.getAll() + "\n");
                    checkRep = true;
                } else {
                    writer.write(account + "\n");
                }
            }

            if (!checkRep) {
                writer.write(userAccount.getAll() + "\n");
            }

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
        User user = new User(null, null, null, null, null, null, null);
        Scanner input = new Scanner(System.in);

        while (!checkError) {
            try {
                System.out.println("Número de identificación:");
                String IDHolder = input.nextLine();

                if (IDHolder.length() == 9 &&
                    (!Character.isDigit(IDHolder.charAt(0)) || !Character.isDigit(IDHolder.charAt(8)))) {
                    user.setID(IDHolder);
                    checkError = true;
                } else {
                    System.out.println("Valor inválido, vuelve a intentarlo:");
                    checkError = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido, vuelve a intentarlo:");
                input.nextLine();
            }
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Assets/Users.txt"));

            for (String u : users) {
                if (u.startsWith(user.getID()) || u.endsWith(user.getEmail() + "," + user.getPassword())) {
                    checkError = true;
                }
                writer.write(u + "\n");
            }

            if (!checkError) {
                writer.write(user.getID() + "," + user.getFirstName() + "," +
                             user.getLastName() + "," + user.getDateOfBirth() + "," +
                             user.getAddress() + "," + user.getEmail() + "," +
                             user.getPassword() + "\n");
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
                System.out.println("Valor inválido, vuelve a intentarlo:");
                input.nextLine();
            }
        } while (checkError);
    }
}
