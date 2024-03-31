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
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "studentid")
  private Long studentID;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "dateofbirth")
  private Date dateOfBirth;

  @Column(name = "emailaddress")
  private String emailAddress;

  @Column(name = "phonenumber")
  private String phoneNumber;

  @Column(name = "address")
  private String address;

  @Override
  public String toString() {
    return "Student{"
        + "studentID="
        + studentID
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", dateOfBirth="
        + dateOfBirth
        + ", emailAddress='"
        + emailAddress
        + '\''
        + ", phoneNumber='"
        + phoneNumber
        + '\''
        + ", address='"
        + address
        + '\''
        + '}';
  }
}
