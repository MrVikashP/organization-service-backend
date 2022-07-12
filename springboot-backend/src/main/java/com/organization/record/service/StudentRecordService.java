package com.organization.record.service;

import com.organization.record.converter.StudentRecordDtoToEntityConverter;
import com.organization.record.converter.StudentRecordDtoToExistingEntityConverter;
import com.organization.record.converter.StudentRecordEntityToDtoConverter;
import com.organization.record.dto.StudentRecordDto;
import com.organization.record.entity.StudentRecord;
import com.organization.record.exception.OrganizationServiceException;
import com.organization.record.helper.consts.StudentRecordConstants;
import com.organization.record.repo.StudentRecordRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@Slf4j
public class StudentRecordService {
    @Autowired
    StudentRecordRepo studentRecordRepo;

    @Autowired
    StudentRecordDtoToEntityConverter studentRecordDtoToEntityConverter;

    @Autowired
    StudentRecordEntityToDtoConverter studentRecordEntityToDtoConverter;

    @Autowired
    StudentRecordDtoToExistingEntityConverter studentRecordDtoToExistingEntityConverter;

    public StudentRecordDto createStudentRecord(StudentRecordDto studentRecordDto) throws Exception {
        StudentRecord existingStudentRecord = getStudentRecordForRollNumber(studentRecordDto.getRollNo());

        if (!isNull(existingStudentRecord)){
            throw new OrganizationServiceException("An student already exists with roll number :" + studentRecordDto.getRollNo());
        }

        setDefaultValues(studentRecordDto);
        StudentRecord studentRecord = getEntityToSave(studentRecordDto);
        studentRecordRepo.save(studentRecord);
        StudentRecordDto studentRecordResponse = studentRecordEntityToDtoConverter.entityToDto(studentRecord);
        return studentRecordResponse;

    }

    public StudentRecord getStudentRecordForRollNumber(Integer rollNo){

        if (isNull(rollNo)){
            log.info("Roll No is empty");
        }
        return studentRecordRepo.findFirstByRollNoAndDeletedFalse(rollNo);
    }

    public void setDefaultValues(StudentRecordDto studentRecordDto){

        if (isNull(studentRecordDto.getDeleted())){
            studentRecordDto.setDeleted(StudentRecordConstants.DEFAULT_DELETED);
        }
    }

    private StudentRecord getEntityToSave(StudentRecordDto studentRecordDto){
        StudentRecord studentRecord = studentRecordDtoToEntityConverter.dtoToEntity(studentRecordDto);
        return studentRecord;
    }

    public StudentRecord updateStudentRecord (StudentRecordDto studentRecordDto) throws Exception {
        log.info("searching students with respective id :" + studentRecordDto.getId());
        StudentRecord existingStudentRecord = studentRecordRepo.findByIdAndAndDeletedFalse(studentRecordDto.getId());
        if (isNull(existingStudentRecord)) {
            throw new OrganizationServiceException("No Record Found For Id :" + studentRecordDto.getId());
        }

        setDefaultValues(studentRecordDto);
        studentRecordDtoToExistingEntityConverter.dtoToExistingEntity(existingStudentRecord, studentRecordDto);
        return studentRecordRepo.save(existingStudentRecord);

    }

    public StudentRecord hardDeleteStudent(Long id) throws Exception {
        log.info("hard deleting student with id :"+ id);
        StudentRecord studentRecord = studentRecordRepo.findByIdAndAndDeletedFalse(id);
        if (isNull(studentRecord)){
            throw new OrganizationServiceException("Student not exists with id :"+ id);
        }
        studentRecordRepo.delete(studentRecord);
        return studentRecord;
    }

    public StudentRecord softDeleteStudent(Long id) throws Exception {
        log.info("soft deleting student with id :"+ id);
        StudentRecord studentRecord = studentRecordRepo.findByIdAndAndDeletedFalse(id);
        if (isNull(studentRecord)){
            throw new OrganizationServiceException("Student not exists with id :"+ id);
        }

        studentRecord.setDeleted(true);
        studentRecordRepo.save(studentRecord);

        return studentRecord;
    }

    public StudentRecordDto getStudentById(Long id) throws Exception {
        log.info("Getting Information Of Student With Id" + id);
        if (isNull(id) || id <=0){
            throw new OrganizationServiceException("Id Must be Positive Value");
        }
        StudentRecord studentRecord = studentRecordRepo.findByIdAndAndDeletedFalse(id);
        if (isNull(studentRecord)){
            throw new OrganizationServiceException("No Record Found For Id :" + id);
        }
        StudentRecordDto studentRecordDto = studentRecordEntityToDtoConverter.entityToDto(studentRecord);
        return studentRecordDto;
    }

    public List<StudentRecordDto> getStudentRecords() throws Exception {
        log.info("Fetching All Student Records");
        List<StudentRecord> studentRecords = studentRecordRepo.findAllByDeletedFalse();
        if (isNull(studentRecords)){
            throw new OrganizationServiceException("Not A Single Record Found");
        }

        List<StudentRecordDto> studentRecordDtos = studentRecordEntityToDtoConverter.entityToDto(studentRecords);
        return studentRecordDtos;
    }


}
