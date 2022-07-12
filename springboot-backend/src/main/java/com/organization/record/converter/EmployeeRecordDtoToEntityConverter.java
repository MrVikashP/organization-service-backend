package com.organization.record.converter;

import com.organization.record.dto.EmployeeRecordDto;
import com.organization.record.entity.EmployeeRecord;
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
