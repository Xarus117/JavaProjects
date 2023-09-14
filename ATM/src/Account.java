
public class Account {

	//Variables
	private String iban;
	private String account_name;
	private String headline;
	private double deposit;
	private String banking_entity;
	
	//Constructors
	public Account(String iban, String account_name, String headline, double deposit, String banking_entity) {
		this.iban = iban;
		this.account_name = account_name;
		this.headline = headline;
		this.deposit = deposit;
		this.banking_entity = banking_entity;
	}

	public Account() {
		
	}

	//Getters
	public String getIban() { return iban; }
	
	public String getAccount_name() { return account_name; }
	
	public String getHeadline() { return headline; }
	
	public double getDeposit() { return deposit; }

	public String getBanking_entity() { return banking_entity; }

	//Setters
	public void setIban(String iban) { this.iban = iban; }

	public void setAccount_name(String account_name) { this.account_name = account_name; }
	
	public void setHeadline(String headline) { this.headline = headline; }

	public void setDeposit(double deposit) { this.deposit = deposit; }

	public void setBanking_entity(String banking_entity) { this.banking_entity = banking_entity; }

}