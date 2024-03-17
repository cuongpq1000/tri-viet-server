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
@Table(name = "testresults")
public class TestResult {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "testresultid")
  private Long testResultID;

  @ManyToOne
  @JoinColumn(name = "studentid")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "courseid")
  private Course course;

  @Column(name = "testname")
  private String testName;

  @Column(name = "score")
  private BigDecimal score;

  @Column(name = "feedback", columnDefinition = "TEXT")
  private String feedback;

  @Column(name = "testdate")
  private Date testDate;
}
