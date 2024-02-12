package org.jsp.crud._rest.controller;

import java.util.List;

import org.jsp.crud._rest.dto.Student;
import org.jsp.crud._rest.helper.ResponseStructure;
import org.jsp.crud._rest.service.Myservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	Myservice service;

	@PostMapping("/students")

	public ResponseEntity<ResponseStructure<Student>> hello(@RequestBody Student student) {
		return service.insert(student);
	}

	@PostMapping("/students/many")

	public ResponseEntity<ResponseStructure<List<Student>>> Students(@RequestBody List<Student> students) {
		return service.insertAll(students);
	}

	@GetMapping("/students")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchAll() {
		return service.fetchAll();
	}

	@GetMapping("/students/id")
	public ResponseEntity<ResponseStructure<Student>> fetchById1(@RequestParam int id) {
		return service.fetchById(id);
	}

	@GetMapping("/students/id/{id}")
	public ResponseEntity<ResponseStructure<Student>> fetchById2(@PathVariable int id) {
		return service.fetchById(id);
	}

	@GetMapping("/students/name/{name}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByName(@PathVariable String name) {
		return service.fetchByName(name);
	}

	@GetMapping("/students/mobile/{mobile}")
	public ResponseEntity<ResponseStructure<Student>> fetchByMobile(@PathVariable long mobile) {
		return service.fetchByMobile(mobile);
	}

	@GetMapping("/students/result/{result}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByResult(@PathVariable String result) {
		return service.fetchByResult(result);
	}

	@GetMapping("/students/percentage/{percentage}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentage(@PathVariable double percentage) {
		return service.fetchByPercentage(percentage);
	}

	@GetMapping("/students/percentage/greater/{percentage}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageGreater(@PathVariable double percentage) {
		return service.fetchByPercentagegreather(percentage);
	}

	@GetMapping("/students/percentage/{percentage1}/{percentage2}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageBetween(@PathVariable double percentage1,
			@PathVariable double percentage2) {
		return service.fetchByPercentageBetween(percentage1, percentage2);
	}

	@GetMapping("/students/percentage/lesser/{percentage}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentagelesser(@PathVariable double percentage) {
		return service.fetchByPercentageless(percentage);
	}

	@GetMapping("/students/maths/english/{marks}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByMathsEnglish(@PathVariable int marks) {
		return service.fetchByMathsEnglish(marks);
	}

	@GetMapping("/students/nameormobile/{data}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByNameorMobile(@PathVariable String data) {
		return service.fetchByNameorMobile(data);
	}

	@DeleteMapping("students/id/{id}")
	public  ResponseEntity<ResponseStructure<Student>> DeleteById(@PathVariable int id){
		return service.deleteById(id);
	}
	@PutMapping("/students")
	public ResponseEntity<ResponseStructure<Student>>update(@RequestBody Student student) {
	return service.update(student);
	}
	@PatchMapping("/students/id/{id}")
	public ResponseEntity<ResponseStructure<Student>> update(@PathVariable int id,@RequestBody Student student) {
		return service.update(id,student);
	}
}

