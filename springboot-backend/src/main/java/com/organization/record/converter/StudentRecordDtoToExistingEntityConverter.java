package com.organization.record.converter;

import com.organization.record.dto.StudentRecordDto;
import com.organization.record.entity.StudentRecord;
import org.springframework.stereotype.Service;

@Service
public class StudentRecordDtoToExistingEntityConverter {

    public StudentRecord dtoToExistingEntity (StudentRecord studentRecord, StudentRecordDto studentRecordDto){

        studentRecord.setCollegeName(studentRecordDto.getCollegeName());
        studentRecord.setStudentName(studentRecordDto.getStudentName());
        studentRecord.setMobileNo(studentRecordDto.getMobileNo());
        studentRecord.setRollNo(studentRecordDto.getRollNo());
        studentRecord.setEmailId(studentRecordDto.getEmailId());
        studentRecord.setDeleted(studentRecordDto.getDeleted());

        return studentRecord;
    }

}
