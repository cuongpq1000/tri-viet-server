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
@Table(name = "enrollment")
public class Enrollment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "enrollmentid")
  private Long enrollmentID;

  @ManyToOne
  @JoinColumn(name = "studentid")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "classid")
  private Classes classes;

  @Column(name = "enrollmentdate")
  private Date enrollmentDate;
}
