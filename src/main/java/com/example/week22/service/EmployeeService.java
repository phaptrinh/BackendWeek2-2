package com.example.week22.service;

import com.example.week22.payload.dto.EmployeeDto;
import com.example.week22.payload.dto.EmployeeDtoV2;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    void deleteEmployeeById(Long employeeId);

    EmployeeDtoV2 getEmployeeByIdV2(Long employeeId);


}
