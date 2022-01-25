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
import model.Stock;
import model.StockUpdateLogic;
import model.Type;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int		item_id = Integer.parseInt(request.getParameter("item_id"));
		String	comment = request.getParameter("comment");
		String	best_by = request.getParameter("best_by");
		
		System.out.println(item_id);
		System.out.println(comment);
		System.out.println(best_by);
		
		Stock stock = new Stock(item_id, comment, best_by);
		
		StockUpdateLogic bo = new StockUpdateLogic();
		boolean ret = bo.execute(stock);
		
		if(ret) {
			HttpSession session = request.getSession();
			
			Type type = (Type) session.getAttribute("type");
			String item_type = type.getItem_type();
			
			System.out.println(item_type);
			
			Account account = (Account) session.getAttribute("account_no");
			int account_no = account.getAccount_no();
			
			System.out.println(account_no);
			
			String url= "ResultServlet?item_type=" + item_type + "&account_no=" + account_no;
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
	}

}



/*
List <Stock> stockList = new ArrayList <Stock>();

int	count = Integer.parseInt(request.getParameter("count"));
for (int i = 1; i <= count; i++ ) {
	int		item_id = Integer.parseInt(request.getParameter("item_id"+i));
	String	comment = request.getParameter("comment"+i);
	String	best_by = request.getParameter("best_by"+i);
	Stock stock = new Stock(item_id, comment, best_by);
	stockList.add(stock);
	
	System.out.println(item_id);
	System.out.println(comment);
	System.out.println(best_by);
}

StockUpdateLogic bo = new StockUpdateLogic();
boolean ret = bo.execute(stockList);

if(ret) {
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
	dispatcher.forward(request, response);
	
}
*/	