package com.organization.record.converter;

import com.organization.record.dto.EmployeeRecordDto;
import com.organization.record.entity.EmployeeRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class EmployeeRecordEntityToDtoConverter {

    public EmployeeRecordDto entityToDto(EmployeeRecord employeeRecord) {

        if (isNull(employeeRecord)){
            return EmployeeRecordDto.builder().build();
        }

        return EmployeeRecordDto.builder()
                .id(employeeRecord.getId())
                .employeeName(employeeRecord.getEmployeeName())
                .role(employeeRecord.getRole())
                .mobileNumber(employeeRecord.getMobileNumber())
                .branch(employeeRecord.getBranch())
                .emailId(employeeRecord.getEmailId())
                .companyName(employeeRecord.getCompanyName())
                .salary(employeeRecord.getSalary())
                .deleted(employeeRecord.getDeleted())
                .build();
    }

    public List<EmployeeRecordDto> entityToDto(List<EmployeeRecord> employeeRecords) {
        return employeeRecords.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
