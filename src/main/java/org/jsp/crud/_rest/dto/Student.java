package org.jsp.crud._rest.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  @Column(unique = true)
  String name;
  long mobile;
  int english;
  int maths;
  int science;
  double percentage;
  String result;
  LocalDate dob;
  
}
