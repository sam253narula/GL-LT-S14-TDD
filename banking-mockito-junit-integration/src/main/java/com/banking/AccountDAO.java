package com.banking;

import java.util.HashMap;
import java.util.Map;

public class AccountDAO {
	static int i = 1;
	Map<Integer, Account> idToAccount = new HashMap<Integer, Account>();

	public int save(Account account) {
		idToAccount.put(i, account);
		return i++;
	}

}
