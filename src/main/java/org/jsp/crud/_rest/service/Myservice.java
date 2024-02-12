package org.jsp.crud._rest.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.jsp.crud._rest.dao.Mydao;
import org.jsp.crud._rest.dto.Student;
import org.jsp.crud._rest.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Myservice {
	@Autowired
	Mydao dao;

	@Autowired
	ResponseStructure<Student> structure;
	
	@Autowired
	ResponseStructure<List<Student>> structure2;

	public ResponseEntity<ResponseStructure<Student>> insert(Student s) {
		s.setPercentage((s.getEnglish() + s.getMaths() + s.getScience()) / 3.0);

		if (s.getMaths() > 35 && s.getEnglish() > 35 && s.getScience() > 35) {

			if (s.getPercentage() >= 85) {
				s.setResult("Distinction");
			} else if (s.getPercentage() >= 60) {
				s.setResult("first class");
			} else {
				s.setResult("Second Class");
			}
		} else {
			s.setResult("Fail");
		}

		structure.setData(dao.save(s));
		structure.setMessage("data Saved Success");
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> insertAll(List<Student> students) {
		for (Student s : students) {
			s.setPercentage((s.getEnglish() + s.getMaths() + s.getScience()) / 3.0);

			if (s.getMaths() > 35 && s.getEnglish() > 35 && s.getScience() > 35) {

				if (s.getPercentage() >= 85) {
					s.setResult("Distinction");
				} else if (s.getPercentage() >= 60) {
					s.setResult("first class");
				} else {
					s.setResult("Second Class");
				}
			} else {
				s.setResult("Fail");
			}
		}
		structure2.setData(dao.saveAll(students));
		structure.setMessage("data Saved Success");
		structure2.setStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure2, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchAll() {
		List<Student> students= dao.fetctAll();
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure2.setData(students);
		structure.setMessage("data Found Sucess");
		structure2.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure2, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Student>>  fetchById(int id) {
		Student student= dao.fetctById(id);
		if (student == null)
			throw new NoSuchElementException("No Records with id: " + id);
		structure.setData(student);
		structure.setMessage("data Found Success");
		structure.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByName(String name) {
		List<Student> students= dao.fetchByName(name);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present with name: " + name);
		structure2.setData(students);
		structure.setMessage("data Found Success");
		structure2.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure2, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Student>> fetchByMobile(long mobile) {
		Student student= dao.fetctByMobile(mobile);
		if (student == null)
			throw new NoSuchElementException("No Records with mobile: " + mobile);
		structure.setData(student);
		structure.setMessage("data Found Success");
		structure.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByResult(String result) {
		List<Student> students= dao.fetchByResult(result);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure2.setData(students);
		structure.setMessage("data Found Success");
		structure2.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure2, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentage(double percentage) {
		List<Student> students= dao.fetchByPercentage(percentage);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure2.setData(students);
		structure.setMessage("data Found Success");
		structure2.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure2, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentagegreather(double percentage) {
		List<Student> students= dao.fetchByPercentageGreaterThanEqual(percentage);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure2.setData(students);
		structure.setMessage("data Found Success");
		structure2.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure2, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageBetween(double percentage1,Double percentage2){
			List<Student> students= dao.fetchByPercentageBetween(percentage1,percentage2);
			if (students.isEmpty())
				throw new NoSuchElementException("No Records Present");
	structure2.setData(students);
	structure.setMessage("data Found Success");
	structure2.setStatus(HttpStatus.FOUND.value());
	
	return new ResponseEntity<ResponseStructure<List<Student>>>(structure2, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageless(double percentage) {
		List<Student> students= dao.fetchByPercentageLessThanEqual(percentage);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure2.setData(students);
		structure.setMessage("data Found Success");
		structure2.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure2, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByMathsEnglish(int marks) {
		List<Student> students= dao.fetchByMathsEnglish(marks);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure2.setData(students);
		structure.setMessage("data Found Success");
		structure2.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure2, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByNameorMobile(String data) {
		List<Student> students=null;
		try {
			students=dao.fetchByNameOrMobile(null,Long.parseLong(data));
		}catch(NumberFormatException e) {
			students=dao.fetchByNameOrMobile(data,0);
		}
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure2.setData(students);
		structure.setMessage("data Found Success");
		structure2.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure2, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Student>> deleteById(int id) {
		dao.deleteById(id);
		return null;
	}

	public ResponseEntity<ResponseStructure<Student>> update(Student student) {
		student.setPercentage((student.getMaths() + student.getScience() + student.getEnglish()) / 3);
		if (student.getScience() < 35 || student.getEnglish() < 35 || student.getMaths() < 35)
			student.setResult("Fail");
		else {
			if (student.getPercentage() >= 85)
				student.setResult("Distinction");
			else if (student.getPercentage() >= 60)
				student.setResult("First Class");
			else
				student.setResult("Second Class");
		}

		structure.setMessage("Data Updated Success");
		structure.setData(dao.save(student));
		structure.setStatus(HttpStatus.OK.value());

		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Student>> update(int id, Student student) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}


