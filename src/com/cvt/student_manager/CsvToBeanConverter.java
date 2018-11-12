package com.cvt.student_manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cvt.student_manager.beans.Student;

public class CsvToBeanConverter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CsvToBeanConverter() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students = new ArrayList<Student>();
		String data = request.getAttribute("data").toString();
		String[] records = data.split(System.lineSeparator());
		String[] attributes;
		Student student;
		for(String record : records) {
			attributes = record.split(",");
			student = new Student();
			student.setRoll(attributes[0]);
			student.setName(attributes[1]);
			student.setYearOfJoining(attributes[2]);
			student.setDob(attributes[3]);
			student.setCurrentClass(attributes[4]);
			students.add(student);
		}
		response.getWriter().write(students.toString());
	}

}
