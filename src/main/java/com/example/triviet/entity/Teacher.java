package com.example.triviet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Teachers")
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TeacherID")
  private Long teacherID;

  @Column(name = "FirstName")
  private String firstName;

  @Column(name = "LastName")
  private String lastName;

  @Column(name = "EmailAddress")
  private String emailAddress;

  @Column(name = "PhoneNumber")
  private String phoneNumber;

  @Column(name = "Specialization")
  private String specialization;
}
