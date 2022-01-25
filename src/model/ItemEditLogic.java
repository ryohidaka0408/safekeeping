package model;

import java.util.List;

import dao.ItemEditDAO;

public class ItemEditLogic {
	public List<ItemEdit> execute(ItemEdit itemEdit) {
		ItemEditDAO dao = new ItemEditDAO();
	
		List<ItemEdit> itemEditList = dao.selectItem(itemEdit);
	
		return itemEditList;
	
	
	}
	
}
