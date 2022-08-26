package com.example.week22.controller;

import com.example.week22.payload.BaseResponse;
import com.example.week22.payload.dto.EmployeeDtoV2;
import com.example.week22.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/employees")
public class EmployeeControllerV2 {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(BaseResponse.success(employeeService.getEmployeeByIdV2(id)));
    }
}
