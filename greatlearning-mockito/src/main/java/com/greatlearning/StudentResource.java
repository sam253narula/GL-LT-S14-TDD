package com.greatlearning;

public class StudentResource {
	
	StudentService studentService;
	AdmissionService admissionService;
	
	public StudentResource(StudentService studentService, AdmissionService admissionService) {
		this.studentService= studentService; 
		this.admissionService = admissionService;
	}
	
	public String saveStudent(String name, int age, String address) {
		Student student  =  new Student(name, age, address);
		int studentId = studentService.saveStudent(student);
		String result  = admissionService.saveAdmission("Admissioned Saved");
		System.out.println(studentId + result);
		return studentId + result ;
	}
}
