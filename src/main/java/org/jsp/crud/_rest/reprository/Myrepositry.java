package org.jsp.crud._rest.reprository;

import java.util.List;

import org.jsp.crud._rest.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Myrepositry extends JpaRepository<Student, Integer> {

	List<Student> findByName(String name);

	Student findByMobile(long mobile);

	List<Student> findByResult(String result);

	List<Student> findByPercentageGreaterThanEqual(double percentage);

	List<Student> findByPercentage(double percentage);

	List<Student> findByPercentageBetween(double percentage1, Double percentage2);

	List<Student> findByPercentageLessThanEqual(double percentage);

	List<Student> findByPercentageBetween(int marks, int marks2);

	List<Student> findByNameOrMobile(String name, long mobile);

}
