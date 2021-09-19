package com.greatlearning;

public class StudentService {
	StudentDAO studentDAO;

	public StudentService(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public int saveStudent(Student student) {
		 int id  = studentDAO.save(student);
		 return id;
	}

}
