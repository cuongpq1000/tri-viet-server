package com.example.triviet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "teachers")
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "teacherid")
  private Long teacherID;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "emailaddress")
  private String emailAddress;

  @Column(name = "password")
  private String password;

  @Column(name = "phonenumber")
  private String phoneNumber;

  @Column(name = "specialization")
  private String specialization;
}
