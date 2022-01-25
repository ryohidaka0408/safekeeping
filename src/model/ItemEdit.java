package model;

public class ItemEdit {
	private int item_id;
	private String item_name;
	private String item_type;
	private int account_no;
	
	public ItemEdit(int item_id, String item_name, String item_type) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_type = item_type;
	}
	
	public ItemEdit(int account_no) {
		this.account_no = account_no;
	
	}

	public int getItem_id() {
		return item_id;
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
