package com.organization.studentrecord.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentRecordDto {

    private Long id;
    private String studentName;
    private Integer rollNo;
    private String collegeName;
    private String emailId;
    private Long mobileNo;
    private Boolean deleted;

}
