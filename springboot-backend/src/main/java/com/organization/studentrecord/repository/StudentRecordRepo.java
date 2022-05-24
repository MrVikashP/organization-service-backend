package com.organization.studentrecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.studentrecord.entity.StudentRecord;

import java.util.List;

@Repository
public interface StudentRecordRepo extends JpaRepository<StudentRecord, Long>{
    List<StudentRecord> findAllByDeletedFalse();

    StudentRecord findByIdAndAndDeletedFalse(Long id);
}
