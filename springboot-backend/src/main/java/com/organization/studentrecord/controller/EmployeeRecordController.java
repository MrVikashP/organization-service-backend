package com.organization.studentrecord.controller;

import com.organization.studentrecord.dto.EmployeeRecordDto;
import com.organization.studentrecord.entity.EmployeeRecord;
import com.organization.studentrecord.exception.OrganizationServiceException;
import com.organization.studentrecord.service.EmployeeRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequestMapping("employee-record")
public class EmployeeRecordController {

    @Autowired
    EmployeeRecordService employeeRecordService;

    //Get All Employee Records
    @GetMapping("/get-all-employee-records")
    public List<EmployeeRecordDto> getAllEmployees() throws Exception {
        List<EmployeeRecordDto> employeeRecords = employeeRecordService.getEmployeeRecords();
        return employeeRecords;
    }

    //Get Employee With ID
    @GetMapping("/get-employee-record/{id}")
    public ResponseEntity<EmployeeRecordDto> getEmployeeById(@PathVariable Long id) throws Exception {
        if(isNull(id) || id <= 0){
            throw new OrganizationServiceException("Employee Id must be Positive value");
        }
        EmployeeRecordDto employeeRecordById = employeeRecordService.getEmployeeById(id);
        return ResponseEntity.ok(employeeRecordById);
    }

    //Create Employee Record
    @PostMapping("/create-employee-record")
    public ResponseEntity<EmployeeRecordDto> createEmployee(@RequestBody EmployeeRecordDto employeeRecordDto) throws Exception {
        EmployeeRecordDto newEmployeeRecord = employeeRecordService.createEmployeeRecord(employeeRecordDto);
        return ResponseEntity.ok(newEmployeeRecord);
    }

    //Update Employee Record
    @PostMapping("/update-employee-record/{id}")
    public ResponseEntity<EmployeeRecord> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRecordDto employeeRecordDto) throws Exception {
        if (isNull(id) || id <=0) {
            throw new OrganizationServiceException("Employee Id Should Be Positive value");
        }
        employeeRecordDto.setId(id);
        EmployeeRecord retVal = employeeRecordService.updateEmployeeRecord(employeeRecordDto);
        if (isNull(retVal)) {
            throw new OrganizationServiceException("Unable To Update Employee Record");
        }

        return ResponseEntity.ok(retVal);
    }

    //Hard Delete Employee Record
    @DeleteMapping("/hard-delete-employee-record/{id}")
    public ResponseEntity<OrganizationServiceException> hardDeleteEmployee(@PathVariable Long id) throws Exception {
        if (isNull(id) || id <=0) {
            throw new OrganizationServiceException("Employee Id Should Be Positive value");
        }
        employeeRecordService.hardDeleteEmployee(id);
        return ResponseEntity.ok(new OrganizationServiceException("Successfully Deleted Employee with Id " + id));
    }

    @PostMapping("/soft-delete-employee-record/{id}")
    public ResponseEntity<OrganizationServiceException> softDeleteEmployee(@PathVariable Long id) throws Exception {
        if (isNull(id) || id <=0) {
            throw new OrganizationServiceException("Employee Id Should Be Positive value");
        }
        employeeRecordService.softDeleteEmployee(id);
        return ResponseEntity.ok(new OrganizationServiceException("Successfully Deleted Employee with Id " + id));
    }

}
