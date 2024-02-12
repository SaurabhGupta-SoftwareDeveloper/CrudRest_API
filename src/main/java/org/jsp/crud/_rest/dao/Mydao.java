package org.jsp.crud._rest.dao;

import java.util.List;

import org.jsp.crud._rest.dto.Student;
import org.jsp.crud._rest.helper.ResponseStructure;
import org.jsp.crud._rest.reprository.Myrepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Mydao {
	@Autowired
	Myrepositry myrepositry;

	public Student save(Student s) {
		
		return myrepositry.save(s);
	}

	public List<Student> saveAll(List<Student> students) {
		
		return myrepositry.saveAll(students);
	}

	public List<Student> fetctAll() {

		return myrepositry.findAll();
	}

	public Student fetctById(int id) {
		
		return myrepositry.findById(id).get();
	}

	public List<Student> fetchByName(String name) {
		return myrepositry.findByName(name);
	}

	public Student fetctByMobile(long mobile) {
		return myrepositry.findByMobile(mobile);
	}

	public List<Student> fetchByResult(String result) {
		return myrepositry.findByResult(result);
	}

	public List<Student> fetchByPercentage(double percentage) {
		return myrepositry.findByPercentage(percentage);
	}

	public List<Student> fetchByPercentageGreaterThanEqual(double percentage) {
		return myrepositry.findByPercentageGreaterThanEqual(percentage);
	}

	public List<Student> fetchByPercentageBetween(double percentage1, Double percentage2) {
		return myrepositry.findByPercentageBetween(percentage1,percentage2);
	}

	public List<Student> fetchByPercentageLessThanEqual(double percentage) {
		return myrepositry.findByPercentageLessThanEqual(percentage);
	}

	public List<Student> fetchByMathsEnglish(int marks) {
		return myrepositry.findByPercentageBetween(marks,marks);
	}

	

	public List<Student> fetchByNameOrMobile(String name, long mobile) {
		return myrepositry.findByNameOrMobile(name,mobile);
	}

	public void deleteById(int id) {
		myrepositry.deleteById(id);
		
	}

   
}
