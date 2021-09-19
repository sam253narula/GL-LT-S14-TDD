package com.greatlearning;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentResourceTest {
	
	@Mock
	private StudentService studentService;

	// Method of mocking withour using @mock annotation
	//private StudentService studentService = Mockito.mock(StudentService.class);
	private StudentResource studentResource;
	
	@Before
	public void setup() {
		studentResource = new StudentResource(studentService);
	} 
	
	@Test
	public void shouldSaveStudent() {
		Student student = new Student("Ankit", 36, "Mumbai,India");
		Mockito.when(studentService.saveStudent(student)).thenReturn(1);
		/*
		 * if you want mockito to match against any Student object and not just above
		 * student object,, then u can use Matchers.any(Student.class)
		 */
		//Mockito.when(studentService.saveStudent(Matchers.any(Student.class))).thenReturn(1);
		int id = studentResource.saveStudent("Ankit", 36, "Mumbai,India");
		Assert.assertEquals(1, id);
		
	}
	
	@Test
	public void shouldSaveStudent_howToDealWithVoidReturnTypeMethods() {
		Student student = new Student("Samarth", 26, "Mumbai,India");
		Mockito.when(studentService.saveStudent(student)).thenReturn(1);
		/*
		 * if you want mockito to match against any Student object and not just above
		 * student object,, then u can use Matchers.any(Student.class)
		 */
		//Mockito.when(studentService.saveStudent(Matchers.any(Student.class))).thenReturn(1);
		int id = studentResource.saveStudent("Samarth", 26, "Mumbai,India");
		// Way to verify logInfo() Method is called during execution of this method
		Mockito.verify(studentService).logInfo();
		Mockito.verify(studentService, Mockito.times(1)).logInfo();
		Mockito.verify(studentService, Mockito.atLeast(1)).logInfo();
		Mockito.verify(studentService, Mockito.atMost(3)).logInfo();
		Mockito.verify(studentService, Mockito.atLeastOnce()).logInfo();
		Mockito.verify(studentService, Mockito.atMostOnce()).logInfo();
		
		Assert.assertEquals(1, id);
		
	}
	
}
