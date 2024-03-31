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
@Table(name = "attendance")
public class Attendance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "attendanceid")
  private Long attendanceID;

  @ManyToOne
  @JoinColumn(name = "studentid")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "classid")
  private Classes classes;

  @Column(name = "date")
  private Date date;

  @Column(name = "status")
  private String status;
}
