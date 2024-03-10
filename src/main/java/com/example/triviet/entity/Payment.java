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
@Table(name = "Payments")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PaymentID")
  private Long paymentID;

  @ManyToOne
  @JoinColumn(name = "StudentID")
  private Student student;

  @Column(name = "Amount")
  private BigDecimal amount;

  @Column(name = "PaymentDate")
  private Date paymentDate;

  @Column(name = "PaymentMethod")
  private String paymentMethod;

}
