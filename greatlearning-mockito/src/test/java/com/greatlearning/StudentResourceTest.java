package com.greatlearning;

import org.mockito.Matchers;
import org.mockito.Mockito;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Any;

public class StudentResourceTest {

	StudentResource studentResource;
	StudentService studentService;
	AdmissionService admissionService;

	public static void main(String[] args) {
		StudentResourceTest resourceTest = new StudentResourceTest();
		resourceTest.setup();
		resourceTest.shouldSaveStudent();
	}

	private void setup() {
		studentService = Mockito.mock(StudentService.class);
		admissionService = Mockito.mock(AdmissionService.class);
		studentResource = new StudentResource(studentService,admissionService);
	}

	private void shouldSaveStudent() {
		Student student = new Student("Samarth", 26, "Mumbai,India");
		Mockito.when(studentService.saveStudent(student)).thenReturn(1);
		Mockito.when(admissionService.saveAdmission(Matchers.anyString())).thenReturn("Admissioned Saved");
		String id = studentResource.saveStudent("Samarth", 26, "Mumbai,India");
		if (id.equalsIgnoreCase("1Admissioned Saved")) {
			System.out.println("test pass");
		}
		else {
			System.out.println("test fail");
		}
	}
}
