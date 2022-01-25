package model;

public class Account {
	private int account_no;
	private String account_register_id;
	private String account_pass;
	private String account_name;

	public Account(String account_register_id, String account_pass, String account_name) {
		this.account_register_id = account_register_id;
		this.account_pass = account_pass;
		this.account_name = account_name;
	}
	
	public Account(int account_no) {
		this.account_no = account_no;
	}

	public String getAccount_register_id() {
		return account_register_id;
	}

	public String getAccount_pass() {
		return account_pass;
	}

	public String getAccount_name() {
		return account_name;
	}

	public int getAccount_no() {
		return account_no;
	}

	
}
