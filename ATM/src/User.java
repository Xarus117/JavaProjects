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
    String password;

    public User(String ID, String firstName, String lastName, Date age, String address, String email, String password) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = age;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public User(String arrayList) {
        String[] data = arrayList.split(",");

        this.ID = data[0];
        this.firstName = data[1];
        this.lastName = data[2];
        this.dateOfBirth = Date.valueOf(data[3]);
        this.address = data[4];
        this.email = data[5];
        this.password = data[6];
    }

    public User() {

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

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }
}
