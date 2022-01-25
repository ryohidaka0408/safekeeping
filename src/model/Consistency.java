package model;

import dao.AccountDAO;

public class Consistency {

	public Account execute(Login login) {
		AccountDAO dao = new AccountDAO();
		
		Account account = dao.account(login);
		
		return account;
	}

}
