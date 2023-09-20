import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.json.JSONException;

public class Main {
    static ArrayList<String> accounts = Reader.read("src/Assets/Accounts.txt");
    static ArrayList<String> users = Reader.read("src/Assets/Users.txt");

    public static void main(String[] args) throws IOException, JSONException {

        // Llamamos al escáner
        Scanner keyboard = new Scanner(System.in);
        // Lo que introduce el usuario por consola
        int intInput = 0;
        String[] loginInput = {"", ""};
        // Para errores
        boolean checkError = false;
        boolean checkErrorRegister = false;
        // Objetos
        User user = new User();
        ArrayList<Account> userAccounts = new ArrayList<Account>();

        do {
            Account.currencyConverter();
            System.out.println("Iniciar sesión: 1\nRegistrarse: 2\n");

            // Setear el booleano en falso
            checkError = false;

            // Revisar errores de entrada
            while (!checkError) {
                try {
                    intInput = keyboard.nextInt();
                    checkError = true;
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido, vuelva a intentarlo\n");
                    keyboard.nextLine();
                }
            }

            checkErrorRegister = false;

            do {

                if (intInput == 1) {
                    System.out.println("Número de identificación:");
                    loginInput[0] = keyboard.next();

                    System.out.println("Contraseña:");
                    loginInput[1] = keyboard.next();

                    user = Reader.login(loginInput);

                    if (user.getID() != null && !user.getID().equals("")) {
                        checkErrorRegister = true;
                    } else {
                        System.out.println("Datos incorrectos\n");
                    }

                } else if (intInput == 2) {

                    Writer.registerUser();
                    checkErrorRegister = false;
                    checkError = false;

                }

            } while (!checkErrorRegister);

        } while (!checkError);

        do {
            System.out.println("\nBienvenid@ " + user.getFirstName() + " " + user.getLastName() + ", ¿qué desea hacer?\n\nIngresar dinero: 1\nRetirar dinero: 2\nMi cuenta: 3\nSalir: 4");

            // Setear el booleano en falso
            checkError = false;

            // Revisar errores de entrada
            while (!checkError) {
                try {
                    intInput = keyboard.nextInt();
                    checkError = true;
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido, vuelva a intentarlo\n");
                    keyboard.nextLine();
                }
            }

            // Opción uno
            if (intInput == 1) {

                // Setear el booleano en falso
                checkError = false;

                userAccounts = Reader.selectAccount(user);

                System.out.println("¿En qué cuenta quiere hacer el depósito?\n");

                for (Account account : userAccounts) {

                    System.out.println((userAccounts.indexOf(account) + 1) + " / " + account.getIban() + " " + account.getAccount_name() + " " + account.getDeposit() + "€");
                }

                int accountSelected = 0;

                // Revisar errores de entrada
                while (!checkError) {
                    try {
                        accountSelected = (keyboard.nextInt() - 1);
                        checkError = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Valor invalido, vuelve a intentarlo\n");
                        keyboard.nextLine();
                    }
                }

                System.out.println("¿Cuánto quiere depositar?");

                double deposit = 0;

                checkError = false;

                // Revisar errores de entrada
                while (!checkError) {
                    try {
                        deposit = keyboard.nextDouble();
                        checkError = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Valor invalido, vuelve a intentarlo\n");
                        keyboard.nextLine();
                    }
                }

                userAccounts.get(accountSelected).setDeposit(userAccounts.get(accountSelected).getDeposit() + deposit);

                // Llamar al escritor de archivo
                Writer.write(userAccounts.get(accountSelected));

                // Opción dos
            } else if (intInput == 2) {

                // Setear el booleano en falso
                checkError = false;

                userAccounts = Reader.selectAccount(user);

                System.out.println("¿En qué cuenta quiere hacer retirar?\n");

                for (Account account : userAccounts) {

                    System.out.println((userAccounts.indexOf(account) + 1) + " / " + account.getIban() + " " + account.getAccount_name() + " " + account.getDeposit() + "€: ");
                }

                int accountSelected = 0;

                // Revisar errores de entrada
                while (!checkError) {
                    try {
                        accountSelected = (keyboard.nextInt() - 1);
                        checkError = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Valor invalido, vuelve a intentarlo\n");
                        keyboard.nextLine();
                    }
                }

                System.out.println("¿Cuánto quiere retirar?");

                double deposit = 0;

                checkError = false;

                // Revisar errores de entrada
                while (!checkError) {
                    try {
                        deposit = keyboard.nextDouble();
                        checkError = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Valor invalido, vuelve a intentarlo\n");
                        keyboard.nextLine();
                    }
                }

                userAccounts.get(accountSelected).setDeposit(userAccounts.get(accountSelected).getDeposit() - deposit);

                // Llamar al escritor de archivo
                Writer.write(userAccounts.get(accountSelected));

                // Opción tres
            } else if (intInput == 3) {
                Writer.RegisterAccount(user);
            }

            // Opción cuatro
        } while (intInput != 4);

        System.out.println("¡Que tenga un buen y español día!");
        // Cerramos teclado
        keyboard.close();
    }
}
