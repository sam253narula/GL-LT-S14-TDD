package com.banking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoSpyTest {


	@Mock
	private AccountDAO accountDAO;

//	@InjectMocks
//	AccountService accountService= new AccountService();
	
	AccountService accountService ;
	
	@Before
	public void setup() {
		 accountService =  new AccountService();
	}

	@Test
	public void demoTest2() {
		AccountService accountSpy = Mockito.spy(accountService);
		accountSpy.logInfo();
		Account account = new Account("987654321", 20000, "Ram Charan", Type.CURRENT);
		
	//	Mockito.when(accountDAO.save(account)).thenReturn(1);
		Mockito.lenient().when(accountDAO.save(account)).thenReturn(1);
		Assert.assertEquals(1, accountService.saveaccount(account));
	}
}
