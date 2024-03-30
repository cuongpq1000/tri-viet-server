package com.example.triviet.controller;

import com.example.triviet.entity.Student;
import com.example.triviet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/list")
  public ResponseEntity<List<Student>> getStudent() {
    return new ResponseEntity<>(studentService.getStudentGroup(), HttpStatus.OK);
  }
}
