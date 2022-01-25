package model;

public class NewItem {
	private String item_name;
	private String item_type;
	private int account_no;
	

	public NewItem(String item_name, String item_type, int account_no) {
		this.item_name = item_name;
		this.item_type = item_type;
		this.account_no = account_no;
	}
	
	public String getItem_name() {
		return item_name;
	}
	public String getItem_type() {
		return item_type;
	}
	public int getAccount_no() {
		return account_no;
	}
}
