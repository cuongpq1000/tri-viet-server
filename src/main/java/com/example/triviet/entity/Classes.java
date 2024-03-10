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
@Table(name = "Classes")
public class Classes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ClassID")
  private Long classID;

  @ManyToOne
  @JoinColumn(name = "CourseID")
  private Course course;

  @ManyToOne
  @JoinColumn(name = "TeacherID")
  private Teacher teacher;

  @Column(name = "StartTime")
  private Date startTime;

  @Column(name = "EndTime")
  private Date endTime;

  @Column(name = "Days")
  private String days;

  @Column(name = "ClassFinalDate")
  private Date classFinalDate;

  @Column(name = "ClassMidtermDate")
  private Date classMidtermDate;

  @Column(name = "ClassRoom")
  private String classRoom;

  @Column(name = "ClassBranch")
  private String classBranch;
}
