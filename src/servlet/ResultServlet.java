package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Record;
import model.RecordLogic;
import model.Type;


@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String item_type = request.getParameter("item_type");
		// account_noの値を取得(session accountListから取得)
		// System.out.println(item_type);
		
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account_no");
		int account_no = account.getAccount_no();
		
		// System.out.println(account_no);
		
		Type type = new Type(item_type, account_no);
		
		session.setAttribute("type", type);
		
		// System.out.println(item_type);
		// System.out.println(account_no);
		
		// recordListの取得
		RecordLogic logic = new RecordLogic();
		List<Record> itemList = logic.execute(type);
		
		if(itemList != null) {
			
			session.setAttribute("itemList", itemList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			String errorMsg2 = "項目がありません。";
			// エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg2", errorMsg2);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/no_item.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		doGet(request,response);
	}

}
