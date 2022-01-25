package model;

import dao.StockEditDAO;

public class StockUpdateLogic {
	public boolean	execute(Stock stock)	{
		StockEditDAO	dao = new StockEditDAO();
		
		return dao.update(stock);
	}
}
