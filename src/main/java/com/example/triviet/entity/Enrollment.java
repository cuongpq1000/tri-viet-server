package com.example.triviet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Enrollment")
public class Enrollment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EnrollmentID")
  private Long enrollmentID;

  @ManyToOne
  @JoinColumn(name = "StudentID")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "ClassID")
  private Classes classes;

  @Column(name = "EnrollmentDate")
  private Date enrollmentDate;
}
