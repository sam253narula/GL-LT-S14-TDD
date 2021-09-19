package com.greatlearning;

import java.util.HashMap;
import java.util.Map;

public class StudentDAO {
	static int i = 1;
	Map<Integer, Student> idToStudent = new HashMap<Integer, Student>();

	public int save(Student student) {
		idToStudent.put(i, student);
		return i++;
	}

}
