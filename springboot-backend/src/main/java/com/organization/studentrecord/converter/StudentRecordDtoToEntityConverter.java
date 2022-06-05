package com.organization.studentrecord.converter;

import com.organization.studentrecord.dto.StudentRecordDto;
import com.organization.studentrecord.entity.StudentRecord;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

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
