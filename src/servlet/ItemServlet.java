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
import model.InsertItemLogic;
import model.ItemEdit;
import model.ItemEditLogic;
import model.NewItem;
import model.Stock;


@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Account account = (Account) session.getAttribute("account_no");
		int account_no = account.getAccount_no();
		
		ItemEdit itemEdit = new ItemEdit(account_no);
		
		ItemEditLogic bo = new ItemEditLogic();
		List<ItemEdit> itemEditList = bo.execute(itemEdit);
		
		session.setAttribute("itemEditList", itemEditList);
		
			// フォワード先の指定
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemedit.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		/************************************/
		/* NewItem生成						*/
		/************************************/
		// itemedit.jspからitem_nameの取得
		String item_name = request.getParameter("item_name");
		// itemedit.jspからitem_typeの取得
		String item_type = request.getParameter("item_type");
		// sessionスコープからaccount_noの値を取得
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account_no");
		int account_no = account.getAccount_no();
		
//		System.out.println(item_name);
//		System.out.println(item_type);
//		System.out.println(account_no);
		
		// getParameterで取得した値をnew_itemに
		NewItem new_item = new NewItem(item_name, item_type, account_no);
	
		/************************************/
		/* Stock生成						*/
		/************************************/		
		
		String comment = request.getParameter("comment");
		String best_by = request.getParameter("best_by");
		
//		System.out.println(comment);
		System.out.println(best_by);
		
		// getParameterで取得した値をstockに
		Stock stock = new Stock(comment,best_by);
		
		/************************************/
		/* InsertItemLogic実行				*/
		/************************************/		
		InsertItemLogic insert_item = new InsertItemLogic();
		
		boolean flag = insert_item.execute(new_item, stock);
		
		if(flag) {
			
			ItemEdit itemEdit = new ItemEdit(account_no);
			
			ItemEditLogic bo = new ItemEditLogic();
			List<ItemEdit> itemEditList = bo.execute(itemEdit);
			
			session.setAttribute("itemEditList", itemEditList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemedit.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			
			
		}
	}

}
