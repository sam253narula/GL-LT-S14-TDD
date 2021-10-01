package com.banking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BankResourceTest {

	@Mock
	private AccountService accountService;

	// Method of mocking without using @mock annotation
	// private accountService accountService = Mockito.mock(accountService.class);
	
//	/private AccountResource accountResource;

//	@Before
//	public void setup() {
//		accountResource = new AccountResource(accountService);
//	}

	//Alternate method of loading before the class loads. By using @injectMocks
	
	@InjectMocks
	AccountResource accountResource;
	
	@Test
	public void shouldSaveaccount() {
		Account account = new Account("987654321", 20000, "Ram Charan", Type.CURRENT);
		Mockito.when(accountService.saveaccount(account)).thenReturn(1);
		/*
		 * if you want mockito to match against any account object and not just above
		 * account object,, then u can use Matchers.any(Account.class)
		 */
		// Mockito.when(accountService.saveaccount(Matchers.any(Account.class))).thenReturn(1);
		int id = accountResource.saveNewAccount("987654321", 20000, "Ram Charan", Type.CURRENT);
		Assert.assertEquals(1, id);

	}

	@Test
	public void shouldSaveaccount_howToDealWithVoidReturnTypeMethods() {
		Account account = new Account("987654321", 50000, "Rajinikanth", Type.CURRENT);
		Mockito.when(accountService.saveaccount(account)).thenReturn(1);
		/*
		 * if you want mockito to match against any account object and not just above
		 * account object,, then u can use Matchers.any(account.class)
		 */
		// Mockito.when(accountService.saveaccount(Matchers.any(account.class))).thenReturn(1);
		int id = accountResource.saveNewAccount("987654321", 50000, "Rajinikanth", Type.CURRENT);
		// Way to verify logInfo() Method is called during execution of this method
		Mockito.verify(accountService).logInfo();
		Mockito.verify(accountService, Mockito.times(1)).logInfo();
		Mockito.verify(accountService, Mockito.atLeast(1)).logInfo();
		Mockito.verify(accountService, Mockito.atMost(3)).logInfo();
		Mockito.verify(accountService, Mockito.atLeastOnce()).logInfo();
		Mockito.verify(accountService, Mockito.atMostOnce()).logInfo();
		
		
		// Below is from Junit 4
		Assert.assertEquals(1, id);
		
		//Below is from Junit 5
		Assertions.assertEquals(1, id);

	}

}
