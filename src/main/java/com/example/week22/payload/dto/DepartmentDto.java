package com.example.week22.payload.dto;

import lombok.Data;

@Data
public class DepartmentDto {
    private Long departmentId;
    private String deptName;
    private String desciption;
    private Long employeeNum;
}
