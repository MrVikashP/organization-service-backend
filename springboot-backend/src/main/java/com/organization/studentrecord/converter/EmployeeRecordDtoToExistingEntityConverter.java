package com.organization.studentrecord.converter;

import com.organization.studentrecord.dto.EmployeeRecordDto;
import com.organization.studentrecord.entity.EmployeeRecord;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRecordDtoToExistingEntityConverter {

    public EmployeeRecord dtoToExistingEntity(EmployeeRecord employeeRecord, EmployeeRecordDto employeeRecordDto){

        employeeRecord.setEmployeeName(employeeRecordDto.getEmployeeName());
        employeeRecord.setRole(employeeRecordDto.getRole());
        employeeRecord.setMobileNumber(employeeRecordDto.getMobileNumber());
        employeeRecord.setCompanyName(employeeRecordDto.getCompanyName());
        employeeRecord.setBranch(employeeRecordDto.getBranch());
        employeeRecord.setEmailId(employeeRecordDto.getEmailId());
        employeeRecord.setSalary(employeeRecordDto.getSalary());

        return employeeRecord;
    }
}
