package com.greatlearning;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoSpyTest {

	@Test
	public void demoTest() {
		List<String> list  = new ArrayList<String>();
		List<String> listSpy = Mockito.spy(list);
		
		listSpy.add("Ankit");
		assertEquals(1, listSpy.size());
		assertEquals("Ankit", listSpy.get(0));
		
		listSpy.add("Samarth");
		assertEquals(2, listSpy.size());
		assertEquals("Samarth", listSpy.get(1));
		
	}
}
