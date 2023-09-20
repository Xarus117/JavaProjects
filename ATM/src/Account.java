import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Account {

    // Variables
    private String iban;
    private String account_name;
    private String headline;
    private double deposit;
    private String banking_entity;

    // Constructors
    public Account(String iban, String account_name, String headline, double deposit, String banking_entity) {
        this.iban = iban;
        this.account_name = account_name;
        this.headline = headline;
        this.deposit = deposit;
        this.banking_entity = banking_entity;
    }

    public Account(String arrayList) {
        String[] data = arrayList.split(",");

        this.iban = data[0];
        this.account_name = data[1];
        this.headline = data[2];
        this.deposit = Double.valueOf(data[3]);
        this.banking_entity = data[4];
    }

    public Account() {

    }

    // Getters
    public String getIban() {
        return iban;
    }

    public String getAccount_name() {
        return account_name;
    }

    public String getHeadline() {
        return headline;
    }

    public double getDeposit() {
        return deposit;
    }

    public String getBanking_entity() {
        return banking_entity;
    }

    public String getAll() {
        return (iban + "," + account_name + "," + headline + "," + deposit + "," + banking_entity);
    }

    // Setters
    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public void setBanking_entity(String banking_entity) {
        this.banking_entity = banking_entity;
    }

    public static void currencyConverter() throws IOException, JSONException {
        Scanner input = new Scanner(System.in);
        System.out.println("Divisa que estamos convirtiendo");
        String convertFrom = input.nextLine();
        System.out.println("Tipo de divisa a la que estamos convirtiendo");
        String convertTo = input.nextLine();
        System.out.println("Cantidad a convertir");
        BigDecimal quantity = input.nextBigDecimal();

        String requestURL = "https://api.exchangerate.host/latest" + convertFrom.toUpperCase();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(requestURL).get().build();
        Response response = client.newCall(request).execute();
        String stringResponse = response.body().string();
        JSONObject jsonObject = new JSONObject(stringResponse);
        JSONObject ratesObject = jsonObject.getJSONObject("rates");

        // Retrieve the rate as a number (assuming it's a number)
        BigDecimal rate = ratesObject.getBigDecimal(convertTo.toUpperCase());

        if (rate == null) {
            throw new JSONException("Rate not found for currency: " + convertTo.toUpperCase());
        }

        BigDecimal result = rate.multiply(quantity);
        System.out.println(result);
    }
}
