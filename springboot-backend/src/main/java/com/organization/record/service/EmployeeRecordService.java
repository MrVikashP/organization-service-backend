package com.organization.record.service;

import com.organization.record.converter.EmployeeRecordDtoToEntityConverter;
import com.organization.record.converter.EmployeeRecordDtoToExistingEntityConverter;
import com.organization.record.converter.EmployeeRecordEntityToDtoConverter;
import com.organization.record.dto.EmployeeRecordDto;
import com.organization.record.entity.EmployeeRecord;
import com.organization.record.exception.OrganizationServiceException;
import com.organization.record.helper.consts.EmployeeRecordConstants;
import com.organization.record.repo.EmployeeRecordRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;


@Slf4j
@Service
public class EmployeeRecordService {

    @Autowired
    EmployeeRecordRepo employeeRecordRepo;
    @Autowired
    EmployeeRecordEntityToDtoConverter employeeRecordEntityToDtoConverter;
    @Autowired
    EmployeeRecordDtoToEntityConverter employeeRecordDtoToEntityConverter;
    @Autowired
    EmployeeRecordDtoToExistingEntityConverter employeeRecordDtoToExistingEntityConverter;

    public List<EmployeeRecordDto> getEmployeeRecords() throws Exception {

        log.info("Fetching All Employee Records");
        List<EmployeeRecord> employeeRecords = employeeRecordRepo.findAllByDeletedFalse();
        if (isNull(employeeRecords)){
            throw new OrganizationServiceException("No Records Found");
        }
        List<EmployeeRecordDto> employeeRecordDtos = employeeRecordEntityToDtoConverter.entityToDto(employeeRecords);
        return employeeRecordDtos;

    }

    public EmployeeRecordDto getEmployeeById(Long id) throws Exception {

        log.info("Searching For Employee With Id " + id);
        EmployeeRecord employeeRecord = employeeRecordRepo.findByIdAndAndDeletedFalse(id);
        if (isNull(employeeRecord)){
            throw new OrganizationServiceException(" No Employee Found With Id " + id);
        }
        EmployeeRecordDto employeeRecordDto = employeeRecordEntityToDtoConverter.entityToDto(employeeRecord);
        return employeeRecordDto;
    }

    public EmployeeRecordDto createEmployeeRecord(EmployeeRecordDto employeeRecordDto) throws Exception {

        log.info("Creating Employee Record");
        setDefaultValue(employeeRecordDto);
        EmployeeRecord employeeRecord = getEntityToSave(employeeRecordDto);
        employeeRecordRepo.save(employeeRecord);
        EmployeeRecordDto newEmployee = employeeRecordEntityToDtoConverter.entityToDto(employeeRecord);
        return newEmployee ;

    }
    private void setDefaultValue(EmployeeRecordDto employeeRecordDto){
        if (isNull(employeeRecordDto.getDeleted())) {
            employeeRecordDto.setDeleted(EmployeeRecordConstants.DEFAULT_DELETED);
        }
    }
    private EmployeeRecord getEntityToSave(EmployeeRecordDto employeeRecordDto) {
        EmployeeRecord employeeRecord = employeeRecordDtoToEntityConverter.dtoToEntity(employeeRecordDto);
        return employeeRecord;
    }

    public EmployeeRecord updateEmployeeRecord(EmployeeRecordDto employeeRecordDto) throws Exception {
        log.info("Updating Employee Record with Id " + employeeRecordDto.getId());
        EmployeeRecord existingEmployRecord = employeeRecordRepo.findByIdAndAndDeletedFalse(employeeRecordDto.getId());
        if (isNull(existingEmployRecord)) {
            throw new OrganizationServiceException("No Record Found For Id " + employeeRecordDto.getId());
        }
        setDefaultValue(employeeRecordDto);
        employeeRecordDtoToExistingEntityConverter.dtoToExistingEntity(existingEmployRecord, employeeRecordDto);
        return employeeRecordRepo.save(existingEmployRecord);

    }

    public EmployeeRecord hardDeleteEmployee(Long id) throws Exception {
        log.info("Hard Deleting Employee Record with Id " + id);
        EmployeeRecord employeeRecord = employeeRecordRepo.findByIdAndAndDeletedFalse(id);
        if (isNull(employeeRecord)) {
            throw new OrganizationServiceException("No Record Found For ID " + id);
        }
        employeeRecordRepo.delete(employeeRecord);
        return employeeRecord;
    }

    public EmployeeRecord softDeleteEmployee(Long id) throws Exception {
        log.info("Soft Deleting Employee with Id "+ id);
        EmployeeRecord employeeRecord = employeeRecordRepo.findByIdAndAndDeletedFalse(id);
        if (isNull(employeeRecord)) {
            throw new OrganizationServiceException(" No Record exists with id "+ id);
        }
        employeeRecord.setDeleted(true);
        employeeRecordRepo.save(employeeRecord);
        return employeeRecord;

    }
}
