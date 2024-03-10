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
@Table(name = "payments")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "paymentid")
  private Long paymentID;

  @ManyToOne
  @JoinColumn(name = "studentid")
  private Student student;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "paymentdate")
  private Date paymentDate;

  @Column(name = "paymentmethod")
  private String paymentMethod;
}
