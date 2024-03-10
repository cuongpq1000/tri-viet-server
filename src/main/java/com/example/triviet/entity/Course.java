package com.example.triviet.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "courseid")
  private Long courseID;

  @Column(name = "coursename")
  private String courseName;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "level")
  private String level;
}
