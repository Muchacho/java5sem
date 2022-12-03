package com.example.studyapp.DB.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GradeUntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String subject;

    private String comment;

    private Integer grade;

    private Integer student;

    public GradeUntity() {
    }

    public GradeUntity(String subject, String comment, Integer grade, Integer student) {
        this.subject = subject;
        this.comment = comment;
        this.grade = grade;
        this.student = student;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }
}
