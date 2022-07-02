package com.organization.studentrecord.converter;

import com.organization.studentrecord.dto.EmployeeRecordDto;
import com.organization.studentrecord.entity.EmployeeRecord;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRecordDtoToEntityConverter {

    public EmployeeRecord dtoToEntity(EmployeeRecordDto employeeRecordDto){

        return EmployeeRecord.builder()
                .id(employeeRecordDto.getId())
                .employeeName(employeeRecordDto.getEmployeeName())
                .role(employeeRecordDto.getRole())
                .companyName(employeeRecordDto.getCompanyName())
                .mobileNumber(employeeRecordDto.getMobileNumber())
                .branch(employeeRecordDto.getBranch())
                .emailId(employeeRecordDto.getEmailId())
                .deleted(employeeRecordDto.getDeleted())
                .salary(employeeRecordDto.getSalary())
                .build();
    }
}
