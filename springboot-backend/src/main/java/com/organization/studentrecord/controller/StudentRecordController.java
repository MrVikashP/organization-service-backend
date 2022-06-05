package com.organization.studentrecord.controller;

import com.organization.studentrecord.dto.StudentRecordDto;
import com.organization.studentrecord.entity.StudentRecord;
import com.organization.studentrecord.exception.OrganizationServiceException;
import com.organization.studentrecord.repo.StudentRecordRepo;
import com.organization.studentrecord.service.StudentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@CrossOrigin(origins = "http://locallhost:3")
@RestController
@RequestMapping("student-record")
public class StudentRecordController {
    @Autowired
    private StudentRecordRepo studentRecordRepo;

    @Autowired
    private StudentRecordService studentRecordService;

    //Get Student Record
    @GetMapping("/get-student-records/{id}")
    public ResponseEntity<StudentRecordDto> getStudentById(@PathVariable Long id) throws Exception {
        StudentRecordDto studentRecordDto = studentRecordService.getStudentById(id);
        return ResponseEntity.ok(studentRecordDto);
    }

    //Get All Student Record
    @GetMapping("/get-all-student-record")
    public List<StudentRecordDto> getAllStudents() throws Exception{
        List<StudentRecordDto> studentRecords = studentRecordService.getStudentRecords();
        return studentRecords;

    }

    //Create Student Record
    @PostMapping("/create-student-record")
    public StudentRecordDto createStudent(@RequestBody StudentRecordDto studentRecordDto) throws Exception {
        return studentRecordService.createStudentRecord(studentRecordDto);
    }

    //Update Student Record
    @PostMapping("/update-student-record/{id}")
    public StudentRecord updateStudent(@PathVariable Long id, @RequestBody StudentRecordDto studentRecordDto) throws Exception {

        if (isNull(id) || id <= 0){
            throw new OrganizationServiceException("Student Id Should Be Positive Value");
        }
        studentRecordDto.setId(id);

        StudentRecord retVal = studentRecordService.updateStudentRecord(studentRecordDto);
        if (isNull(retVal)){
            throw new OrganizationServiceException("Failed to update student record");
        }
        return retVal;
    }

    // Hard delete student record
    @DeleteMapping("/hard-delete-student-record/{id}")
    public ResponseEntity<StudentRecord> hardDeleteStudent(@PathVariable Long id) throws Exception {
        StudentRecord studentRecord = studentRecordService.hardDeleteStudent(id);
        return ResponseEntity.ok(studentRecord);
    }

    // Soft Delete student record
    @PostMapping("/soft-delete-student-record/{id}")
    public ResponseEntity<StudentRecord> softDeleteStudent(@PathVariable Long id) throws Exception {
        StudentRecord studentRecord = studentRecordService.softDeleteStudent(id);
        return ResponseEntity.ok(studentRecord);
    }

}
