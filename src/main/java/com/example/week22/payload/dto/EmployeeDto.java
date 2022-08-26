package com.example.week22.payload.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {
    private Long employeeId;
    private String name;
    private Date birthDate;
    private String gender;
    private Long departmentId;
}
