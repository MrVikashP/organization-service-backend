package com.organization.record.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@Data
@Entity
@Table(name = "EmployeeRecord")

public class  EmployeeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "EmployeeName")
    private String employeeName;
    @Column(name = "Role")
    private String role;
    @Column(name = "CompanyName")
    private String companyName;
    @Column(name = "MobileNumber")
    private Long mobileNumber;
    @Column(name = "EmailId")
    private String emailId;
    @Column(name = "Branch")
    private String branch;
    @Column(name = "Salary")
    private Long salary;
    @Column(name = "Deleted")
    private Boolean deleted;

    public EmployeeRecord() {

    }

    public EmployeeRecord(String employeeName, String role, String companyName, Long mobileNumber, String emailId, String branch, Long salary, Boolean deleted) {

        super();
        this.employeeName = employeeName;
        this.role = role;
        this.companyName = companyName;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.branch = branch;
        this.salary = salary;
        this.deleted = deleted;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
