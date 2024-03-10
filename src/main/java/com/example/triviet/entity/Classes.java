package com.example.triviet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classes")
public class Classes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "classid")
  private Long classID;

  @ManyToOne
  @JoinColumn(name = "courseid")
  private Course course;

  @ManyToOne
  @JoinColumn(name = "teacherid")
  private Teacher teacher;

  @Column(name = "starttime")
  private Date startTime;

  @Column(name = "endtime")
  private Date endTime;

  @Column(name = "days")
  private String days;

  @Column(name = "classfinaldate")
  private Date classFinalDate;

  @Column(name = "classmidtermdate")
  private Date classMidtermDate;

  @Column(name = "classroom")
  private String classRoom;

  @Column(name = "classbranch")
  private String classBranch;
}
