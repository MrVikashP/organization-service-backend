package com.organization.record.converter;

import com.organization.record.dto.StudentRecordDto;
import com.organization.record.entity.StudentRecord;
import org.springframework.stereotype.Service;

@Service
public class StudentRecordDtoToEntityConverter {
    public StudentRecord dtoToEntity(StudentRecordDto studentRecordDto){

        return StudentRecord.builder()
                .id(studentRecordDto.getId())
                .collegeName(studentRecordDto.getCollegeName())
                .studentName(studentRecordDto.getStudentName())
                .emailId(studentRecordDto.getEmailId())
                .mobileNo(studentRecordDto.getMobileNo())
                .rollNo(studentRecordDto.getRollNo())
                .deleted(studentRecordDto.getDeleted())
                .build();
    }
}
