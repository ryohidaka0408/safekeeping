package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Consistency;
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String account_register_id = request.getParameter("account_register_id");
		String account_pass = request.getParameter("account_pass");
		
		// ログイン処理の実行
		Login login = new Login(account_register_id, account_pass);
		
		// 引数の値とDB内のアカウントの整合性をboolean型で取得
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		
		// accountListの取得
		Consistency con = new Consistency();
		Account account_no = con.execute(login);
		
		// System.out.println(account_no);	
		
		// ログイン処理の成否によって処理を分岐
		if (result) {// ログイン成功時
			
			// セッションスコープにユーザー情報(全て)を保存
			HttpSession session = request.getSession();
			session.setAttribute("account_no", account_no);
			
			session.setAttribute("account_register_id", account_register_id);
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		
		} else {// ログイン失敗時
			
			// リダイレクト
			response.sendRedirect("/safekeeping/LoginServlet");
		}
	}

}
