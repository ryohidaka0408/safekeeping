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
import model.RegisterAccountLogic;

@WebServlet("/RegisterAccount")
public class RegisterAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// フォワード先
		String forwardPath = null;

		// サーブレットクラスの動作を決定する「action」の値を
		// リクエストパラメータから取得
		String action = request.getParameter("action");

		// 「登録の開始」をリクエストされたときの処理
		if (action == null) {
			// フォワード先を設定
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";
		}

		// 登録確認画面から「登録実行」をリクエストされたときの処理
		else if (action.equals("done")) {
			// セッションスコープに保存された登録アカウントを取得
			HttpSession session = request.getSession();
			Account registerAccount = (Account) session.getAttribute("registerAccount");

			// 登録処理の呼び出し
			RegisterAccountLogic logic = new RegisterAccountLogic();
			boolean registration = logic.execute(registerAccount);

			// 不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("registerAccount");

			// 新規登録出来た場合（IDが登録済みではなかった）
			if (registration) {
				// 登録後のフォワード先を設定
				forwardPath = "/WEB-INF/jsp/registerDone.jsp";
			} else {// 登録済みだった場合
				String errorMsg = "登録済みのIDです";
				// エラーメッセージをリクエストスコープに保存
				request.setAttribute("errorMsg", errorMsg);
				// フォワード
				forwardPath = "/WEB-INF/jsp/registerConfirm.jsp";
			}
		}

		// 設定されたフォワード先にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String account_register_id = request.getParameter("account_register_id");
		String account_pass = request.getParameter("account_pass");
		String account_name = request.getParameter("account_name");

		// リクエストパラメータをチェック（今回は「registerConfirm.jsp」のif文用に入れているだけ）
		String errorMsg = "";

		// エラーメッセージをリクエストスコープに保存（今回は「registerConfirm.jsp」のif文用に入れているだけ）
		request.setAttribute("errorMsg", errorMsg);

		// 登録するユーザーの情報を設定
		Account registerAccount = new Account(account_register_id, account_pass, account_name);

		// セッションスコープに登録ユーザーを保存
		HttpSession session = request.getSession();
		session.setAttribute("registerAccount", registerAccount);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}

}
