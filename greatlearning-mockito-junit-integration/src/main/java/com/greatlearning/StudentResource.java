package com.greatlearning;

public class StudentResource {
	
	StudentService studentService;
	
	public StudentResource(StudentService studentService) {
		this.studentService= studentService; 
	}
	
	public int saveStudent(String name, int age, String address) {
		Student student  =  new Student(name, age, address);
		int studentId = studentService.saveStudent(student);
		studentService.logInfo();
		return studentId;
	}
	
}
