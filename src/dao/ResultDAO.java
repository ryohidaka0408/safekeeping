package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Record;
import model.Type;

public class ResultDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/safekeeping?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	
	public List<Record> record(Type type) {
		List<Record> itemList = new ArrayList<>(); // 空のArrayListを作成
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "SELECT ITEM.ITEM_ID, ITEM.ITEM_NAME, ITEM.ITEM_TYPE, STOCK.COMMENT, STOCK.BEST_BY FROM ITEM "
						+"JOIN STOCK ON ITEM.ITEM_ID = STOCK.ITEM_ID WHERE ITEM.ITEM_TYPE = ? AND ITEM.ACCOUNT_NO = ? "
						+"ORDER BY ITEM.ITEM_ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, type.getItem_type());
			pStmt.setInt(2, type.getAccount_no());
			
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) { 
				int item_id = rs.getInt("ITEM.ITEM_ID");
				String item_name = rs.getString("ITEM.ITEM_NAME");
				String item_type = rs.getString("ITEM.ITEM_TYPE");
				String comment = rs.getString("STOCK.COMMENT");
				Date best_by = rs.getDate("STOCK.BEST_BY");
				
				Record record = new Record(item_id, item_name, item_type, comment, best_by); 
				itemList.add(record);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return itemList;
	}

}
