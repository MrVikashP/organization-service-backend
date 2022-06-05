package com.organization.studentrecord.converter;

import com.organization.studentrecord.dto.StudentRecordDto;
import com.organization.studentrecord.entity.StudentRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class StudentRecordEntityToDtoConverter {
    public StudentRecordDto entityToDto(StudentRecord studentRecord){
        if (isNull(studentRecord)){
            return StudentRecordDto.builder().build();
        }
        return StudentRecordDto.builder()
                .id(studentRecord.getId())
                .collegeName(studentRecord.getCollegeName())
                .studentName(studentRecord.getStudentName())
                .emailId(studentRecord.getEmailId())
                .mobileNo(studentRecord.getMobileNo())
                .rollNo(studentRecord.getRollNo())
                .deleted(studentRecord.getDeleted())
                .build();
    }

    public List<StudentRecordDto> entityToDto(List<StudentRecord> studentRecordList){
        return studentRecordList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

}
