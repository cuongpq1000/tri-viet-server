package com.example.triviet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Attendance")
public class Attendance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "AttendanceID")
  private Long attendanceID;

  @ManyToOne
  @JoinColumn(name = "StudentID")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "ClassID")
  private Classes classes;

  @Column(name = "Date")
  private Date date;

  @Column(name = "Status")
  private String status;
}
