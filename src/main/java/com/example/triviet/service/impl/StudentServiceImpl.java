package com.example.triviet.service.impl;

import com.example.triviet.entity.Student;
import com.example.triviet.repository.StudentRepository;
import com.example.triviet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
  private final StudentRepository studentRepository;

  @Autowired
  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public List<Student> getStudentGroup() {
    return studentRepository.findAll();
  }
}
