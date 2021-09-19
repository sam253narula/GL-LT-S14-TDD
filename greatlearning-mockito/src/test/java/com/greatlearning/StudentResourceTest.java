package com.greatlearning;

import org.mockito.Mockito;

public class StudentResourceTest {

	StudentResource studentResource;
	StudentService studentService;

	public static void main(String[] args) {
		StudentResourceTest resourceTest = new StudentResourceTest();
		resourceTest.setup();
		resourceTest.shouldSaveStudent();
	}

	private void setup() {
		studentService = Mockito.mock(StudentService.class);
		studentResource = new StudentResource(studentService);
	}

	private void shouldSaveStudent() {
		Student student = new Student("Samarth", 26, "Mumbai,India");
		Mockito.when(studentService.saveStudent(student)).thenReturn(1);
		int id = studentResource.saveStudent("Samarth", 26, "Mumbai,India");
		if (id == 1) {
			System.out.println("test pass");
		}
		else {
			System.out.println("test fail");
		}
	}
}
