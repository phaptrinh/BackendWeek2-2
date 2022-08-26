package com.example.week22.service;

import com.example.week22.entity.Department;
import com.example.week22.payload.dto.DepartmentDto;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department createDepartment(Department departmentDto);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    DepartmentDto getDepartmentByIdWithEmployeeNumber(Long departmentId);
}
