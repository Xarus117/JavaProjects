
public class Account {

	//Variables
	private String iban;
	private String headline;
	private float deposit;
	private String banking_entity;
	
	//Constructors
	public Account(String iban, String headline, float deposit, String banking_entity) {
		this.iban = iban;
		this.headline = headline;
		this.deposit = deposit;
		this.banking_entity = banking_entity;
	}

	public Account() {
		
	}

	//Getters
	public String getIban() { return iban; }
	
	public String getHeadline() { return headline; }
	
	public float getDeposit() { return deposit; }

	public String getBanking_entity() { return banking_entity; }

	//Setters
	public void setIban(String iban) { this.iban = iban; }

	public void setHeadline(String headline) { this.headline = headline; }

	public void setDeposit(float deposit) { this.deposit = deposit; }

	public void setBanking_entity(String banking_entity) { this.banking_entity = banking_entity; }

}