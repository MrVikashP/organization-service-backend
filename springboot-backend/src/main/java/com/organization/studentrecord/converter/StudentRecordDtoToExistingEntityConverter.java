package com.organization.studentrecord.converter;

import com.organization.studentrecord.dto.StudentRecordDto;
import com.organization.studentrecord.entity.StudentRecord;
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
