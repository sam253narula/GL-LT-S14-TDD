package com.banking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoSpyTest {

	
	@Mock
	private AccountService accountService;
	
	@Test
	public void demoTest2() {
		AccountDAO accountDAO = new AccountDAO();
		AccountService accountService = new AccountService(accountDAO);
		AccountService accountSpy = Mockito.spy(accountService);
		int studentId = accountSpy.saveaccount(new Account("987654321", 20000, "Ram Charan", Type.CURRENT));
		Assert.assertEquals(1, studentId);
	}
}
