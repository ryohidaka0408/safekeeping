package model;

import dao.ItemEditDAO;
import dao.StockEditDAO;

public class InsertItemLogic {

	public boolean execute(NewItem new_item,Stock stock) {
		ItemEditDAO dao = new ItemEditDAO();
		// IDが登録済みか確認
		int item_id = dao.insertItem(new_item);
		
		if(item_id < 0) {

			return false;
		
		}
		StockEditDAO se = new StockEditDAO();
		
		boolean registration = se.insertStock(stock,item_id);
		
		return registration;
	
	}

}
