package com.greatlearning;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoSpyTest {

	
	@Mock
	private StudentService studentService;
	
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
		
		System.out.println("listSpy"+ listSpy);
		System.out.println("list"+ list);
		
	}
	
	@Test
	public void demoTest2() {
		StudentDAO studentDAO = new StudentDAO();
		StudentService studentService = new StudentService(studentDAO);
		StudentService studentSpy = Mockito.spy(studentService);
		int studentId = studentSpy.saveStudent(new Student("Samarth", 26, "Mumbai,India"));
		Assert.assertEquals(1, studentId);
	}
}
