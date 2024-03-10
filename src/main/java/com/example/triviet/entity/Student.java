package com.example.triviet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "StudentID")
  private Long studentID;

  @Column(name = "FirstName")
  private String firstName;

  @Column(name = "LastName")
  private String lastName;

  @Column(name = "DateOfBirth")
  private Date dateOfBirth;

  @Column(name = "EmailAddress")
  private String emailAddress;

  @Column(name = "PhoneNumber")
  private String phoneNumber;

  @Column(name = "Address")
  private String address;
}
