package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Stock;

public class StockEditDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/safekeeping?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public boolean insertStock(Stock stock, int item_id) {
	
	try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

		// INSERT文の準備
		String sql = "INSERT INTO STOCK(COMMENT, BEST_BY, ITEM_ID) VALUES(?,?,?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// INSERT文中の「?」に使用する値を設定しSQLを完成
		pStmt.setString(1, stock.getComment());// 1つ目の「?」
		
        pStmt.setString(2, stock.getBest_by());// 2つ目の「?」
		pStmt.setInt(3, item_id);// 3つ目の「?」

		// INSERTを実行（resultには正常終了した場合は「1」、正常終了しなかった場合は「0」が代入される）
		int result = pStmt.executeUpdate();
		if (result != 1) {
			
			return false;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	
	return true;
	}

	public boolean update(Stock stock) {

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE STOCK SET COMMENT=?, BEST_BY=? WHERE ITEM_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, stock.getComment());// 1つ目の「?」
			pStmt.setString(2, stock.getBest_by());// 2つ目の「?」
			pStmt.setInt(3, stock.getItem_id());// 3つ目の「?」
			
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		
		}
		return true;
	}	
}

	
	
	
	
	/*			
	for ( Stock stock : stockList )	{
		// INSERT文の準備
		String sql = "UPDATE STOCK SET COMMENT=?, BEST_BY=? WHERE ITEM_ID=?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// INSERT文中の「?」に使用する値を設定しSQLを完成
		pStmt.setString(1, stock.getComment());// 1つ目の「?」
		pStmt.setString(2, stock.getBest_by());// 2つ目の「?」
		pStmt.setInt(3, stock.getItem_id());// 3つ目の「?」

		// UPDATEを実行（resultには正常終了した場合は「1」、正常終了しなかった場合は「0」が代入される）
		int result = pStmt.executeUpdate();
		if (result != 1) {
			ret = false;
			break;
		}
	}
} catch (SQLException e) {
	e.printStackTrace();
	return false;
}

return ret;
}
*/	