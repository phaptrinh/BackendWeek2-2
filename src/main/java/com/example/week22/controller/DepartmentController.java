package com.example.week22.controller;

import com.example.week22.entity.Department;
import com.example.week22.payload.BaseResponse;
import com.example.week22.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getAllDepartments() {
        return ResponseEntity.ok(BaseResponse.success(departmentService.getAllDepartments()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(BaseResponse.success(departmentService.getDepartmentById(id)));
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(BaseResponse.success(departmentService.createDepartment(department)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartmentById(@PathVariable Long id) {
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.ok(BaseResponse.success(null));

    }
}
