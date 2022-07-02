package com.organization.studentrecord.repo;

import com.organization.studentrecord.entity.EmployeeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRecordRepo extends JpaRepository<EmployeeRecord, Long> {

    List<EmployeeRecord> findAllByDeletedFalse();

    EmployeeRecord findByIdAndAndDeletedFalse(Long id);


}
