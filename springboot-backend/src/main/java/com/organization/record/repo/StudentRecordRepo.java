package com.organization.record.repo;
import com.organization.record.entity.StudentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRecordRepo extends JpaRepository<StudentRecord, Long> {
    List<StudentRecord> findAllByDeletedFalse();

    StudentRecord findByIdAndAndDeletedFalse(Long Id);

    StudentRecord findFirstByRollNoAndDeletedFalse(Integer rollNo);

}
