package edu.mum.cs544;

import javax.persistence.*;

@Entity(name = "edu.mum.cs544.Grades")
@Table(name = "grades")
public class Grades {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;
  @Column(name = "student_id", nullable = false)
  private Integer studentId;
  @Column(name = "course_id", nullable = false)
  private Integer courseId;
  @Column(name = "grade", nullable = true)
  private String grade;
  public Grades() {
  }
  public Grades(Integer id, Integer studentId, Integer courseId, String grade) {
    this.id = id;
    this.studentId = studentId;
    this.courseId = courseId;
    this.grade = grade;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Integer getStudentId() {
    return studentId;
  }
  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }
  public Integer getCourseId() {
    return courseId;
  }
  public void setCourseId(Integer courseId) {
    this.courseId = courseId;
  }
  public String getGrade() {
    return grade;
  }
  public void setGrade(String grade) {
    this.grade = grade;
  }
}