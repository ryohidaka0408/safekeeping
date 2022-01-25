package model;

import java.sql.Date;

public class Record {
	private int item_id;
	private String item_name;
	private String item_type;
	private String comment;
	private Date best_by;
	private int account_no;
	
	
	public Record(int item_id,String item_name,String item_type,String comment,Date best_by) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_type = item_type;
		this.comment = comment;
		this.best_by = best_by;
	
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

	public String getComment() {
		return comment;
	}

	public Date getBest_by() {
		return best_by;
	}

	public int getAccount_no() {
		return account_no;
	}
	
}
