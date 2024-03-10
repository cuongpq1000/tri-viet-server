package com.example.triviet.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CourseID")
  private Long courseID;

  @Column(name = "CourseName")
  private String courseName;

  @Column(name = "Description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "Level")
  private String level;
}
