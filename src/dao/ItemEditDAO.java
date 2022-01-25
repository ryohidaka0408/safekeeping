package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ItemEdit;
import model.NewItem;

public class ItemEditDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/safekeeping?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	
	public List<ItemEdit> selectItem(ItemEdit itemEdit) {
		List<ItemEdit> itemEditList = new ArrayList<>(); // 空のArrayListを作成
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "SELECT ITEM_ID, ITEM_NAME, ITEM_TYPE FROM ITEM "
						+"WHERE ITEM.ACCOUNT_NO = ? "
						+"ORDER BY ITEM_ID ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, itemEdit.getAccount_no());
			
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) { 
				int item_id = rs.getInt("ITEM_ID");
				String item_name = rs.getString("ITEM_NAME");
				String item_type = rs.getString("ITEM_TYPE");
				
				ItemEdit e = new ItemEdit(item_id, item_name, item_type); 
				itemEditList.add(e);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return itemEditList;
	}

	public int insertItem(NewItem new_item) {
	
		// item_idの初期化
		int item_id = 0;

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// INSERT文の準備
			String sql = "INSERT INTO ITEM(ITEM_NAME, ITEM_TYPE, ACCOUNT_NO) VALUES(?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, new_item.getItem_name());// 1つ目の「?」
			pStmt.setString(2, new_item.getItem_type());// 2つ目の「?」
			pStmt.setInt(3, new_item.getAccount_no());// 3つ目の「?」
			
			int item = pStmt.executeUpdate();
			ResultSet rs = pStmt.executeQuery("SELECT LAST_INSERT_ID() AS LAST");
			
			// item_idの取得			
			if(rs != null && rs.next()) {
				item_id = rs.getInt("LAST");
			}
			System.out.println("item_id=" + item_id);
			
			if (item != 1) {
				
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
		return item_id ;
	}

}
