package com.example.triviet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TestResults")
public class TestResult {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TestResultID")
  private Long testResultID;

  @ManyToOne
  @JoinColumn(name = "StudentID")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "CourseID")
  private Course course;

  @Column(name = "TestName")
  private String testName;

  @Column(name = "Score")
  private BigDecimal score;

  @Column(name = "Feedback", columnDefinition = "TEXT")
  private String feedback;

  @Column(name = "TestDate")
  private Date testDate;
}
