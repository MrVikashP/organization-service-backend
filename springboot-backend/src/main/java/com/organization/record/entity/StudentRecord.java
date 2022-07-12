package com.organization.record.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@Data
@Entity
@Table(name = "StudentRecord")
public class StudentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "StudentName")
    private String studentName;

    @Column(name = "CollegeName")
    private String collegeName;

    @Column(name = "RollNo")
    private Integer rollNo;

    @Column(name = "MobileNo")
    private Long mobileNo;

    @Column(name = "EmailId")
    private String emailId;

    @Column(name = "Deleted")
    private Boolean deleted;

    public StudentRecord(){

    }

    public StudentRecord(String studentName, String collegeName, Integer rollNo, Long mobileNo, String emailId, Boolean deleted){
        super();
        this.studentName = studentName;
        this.collegeName = collegeName;
        this.rollNo = rollNo;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
