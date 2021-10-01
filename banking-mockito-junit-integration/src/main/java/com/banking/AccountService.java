package com.banking;

public class AccountService {
	
	AccountDAO accountDAO = new AccountDAO();

//	public AccountService(AccountDAO accountDAO) {
//		this.accountDAO = accountDAO;
//	}

	public int saveaccount(Account account) {
		System.out.println("Save Account");
		 int id  = accountDAO.save(account);
		 return id;
	}
	
	public void logInfo() {
		System.out.println("saving a new account");
	}

}
