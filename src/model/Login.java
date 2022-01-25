package model;

public class Login {
	private String account_register_id;
	private String account_pass;

	public Login(String account_register_id, String account_pass) {
		this.account_register_id = account_register_id;
		this.account_pass = account_pass;
	}

	public String getAccount_register_id() {
		return account_register_id;
	}

	public String getAccount_pass() {
		return account_pass;
	}

}
