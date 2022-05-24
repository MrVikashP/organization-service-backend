package com.organization.studentrecord.repository;

import com.organization.studentrecord.entity.EmployeeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRecordRepo extends JpaRepository<EmployeeRecord, Long> {

}
