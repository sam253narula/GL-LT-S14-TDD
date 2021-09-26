package com.banking;

public class AccountResource {
	
	AccountService accountService;
	
	public AccountResource(AccountService accountService) {
		this.accountService= accountService; 
	}
	
	public int saveNewAccount(String accountNumber, int balance, String owner, Type type) {
		Account account  =  new Account(accountNumber, balance, owner, type);
		int accountId = accountService.saveaccount(account);
		accountService.logInfo();
		return accountId;
	}
	
}
