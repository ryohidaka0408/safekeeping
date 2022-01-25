package model;

public class Stock {
	private int		item_id;
	private String comment;
	private String best_by;
	
	public Stock(int item_id, String comment, String best_by) {
		this.item_id = item_id;
		this.comment = comment;
		this.best_by = best_by;
	}

	public Stock(String comment, String best_by) {
		this.comment = comment;
		this.best_by = best_by;
	}

	public int getItem_id() {
		return item_id;
	}

	public String getComment() {
		return comment;
	}

	public String getBest_by() {
		return best_by;
	}

}
