package model;

public class Type {
	private String item_type;
	private int account_no;
	
	public Type(String item_type,int account_no) {
		this.item_type = item_type;
		this.account_no = account_no;	
	}
	
	public String getItem_type() {
		return item_type;
	}

	public int getAccount_no() {
		return account_no;
	}
	
}
