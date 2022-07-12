package com.organization.record.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class EmployeeRecordDto {

    private Long id;
    private String employeeName;
    private String role;
    private String companyName;
    private Long mobileNumber;
    private String emailId;
    private String branch;
    private Long salary;
    private Boolean deleted;

}
