package com.example.week22.controller;

import com.example.week22.payload.BaseResponse;
import com.example.week22.payload.dto.DepartmentDto;
import com.example.week22.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/departments")
public class DepartmentControllerV2 {
    @Autowired
    DepartmentService departmentService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(BaseResponse.success(departmentService.getDepartmentByIdWithEmployeeNumber(id)));

    }
}
