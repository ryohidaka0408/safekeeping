package model;

import java.util.List;

import dao.ResultDAO;

public class RecordLogic {

	public List<Record> execute(Type type) {
		ResultDAO dao = new ResultDAO();
	
		List<Record> itemList = dao.record(type);
		// System.out.println(itemList.get(0).getItem_name());
		return itemList;
	}
}
