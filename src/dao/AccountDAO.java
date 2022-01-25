package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/safekeeping?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public Account findByLogin(Login login) {// ログイン用（変更なし）
		Account account = null;

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT ACCOUNT_REGISTER_ID, ACCOUNT_PASS, ACCOUNT_NAME FROM ACCOUNT WHERE ACCOUNT_REGISTER_ID = ? AND ACCOUNT_PASS = ?";/* SQL文は小文字で入力してもOK */
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getAccount_register_id());
			pStmt.setString(2, login.getAccount_pass());

			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したユーザーが存在した場合
			// そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				// 結果表からデータを取得
				String account_register_id = rs.getString("ACCOUNT_REGISTER_ID");/* 「"pass"」と入力してもOK */
				String account_pass = rs.getString("ACCOUNT_PASS");
				String account_name = rs.getString("ACCOUNT_NAME");
				account = new Account(account_register_id,account_pass,account_name);
				
				System.out.println(account);//内容確認(account)
				
			}
			
		} catch (SQLException e) {
			return null;
		}
		
		return account;
	}

	/* 以下、ユーザー登録用に追加 */
	public boolean findByAccount(Account account) {
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT ACCOUNT_REGISTER_ID, ACCOUNT_PASS FROM ACCOUNT WHERE ACCOUNT_REGISTER_ID = ? AND ACCOUNT_PASS = ?";/* SQL文は小文字で入力してもOK */
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getAccount_register_id());
			pStmt.setString(2, account.getAccount_pass());
			
			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したユーザーが存在した場合（登録済みのID）、trueを返す
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		// ユーザーが見つからなかったら（未登録のID）、falseを返す
		return false;
	}
	public boolean create(Account account) {
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// INSERT文の準備
			String sql = "INSERT INTO ACCOUNT(ACCOUNT_REGISTER_ID, ACCOUNT_PASS, ACCOUNT_NAME) VALUES(?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, account.getAccount_register_id());// 1つ目の「?」
			pStmt.setString(2, account.getAccount_pass());// 2つ目の「?」
			pStmt.setString(3, account.getAccount_name());// 3つ目の「?」

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

	public Account account(Login login) {
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "SELECT ACCOUNT_NO FROM ACCOUNT WHERE ACCOUNT_REGISTER_ID = ? AND ACCOUNT_PASS = ?";/* SQL文は小文字で入力してもOK */
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getAccount_register_id());
			pStmt.setString(2, login.getAccount_pass());
			
			ResultSet rs = pStmt.executeQuery();
			Account account=null;
			if (rs.next()) { 
				int account_no = rs.getInt("ACCOUNT_NO");
				
				account = new Account(account_no); 
			}
				return account;

			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
