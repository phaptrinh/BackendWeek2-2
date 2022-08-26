package com.example.week22.service.impl;

import com.example.week22.entity.Department;
import com.example.week22.exception.RecordNotFoundException;
import com.example.week22.payload.dto.DepartmentDto;
import com.example.week22.repository.DepartmentJpaRepository;
import com.example.week22.repository.MybatisRepository;
import com.example.week22.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentJpaRepository departmentJpaRepository;

    @Resource
    MybatisRepository mybatisRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentJpaRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentJpaRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentJpaRepository.findById(departmentId).orElseThrow(() -> new RecordNotFoundException("Not found department with id = " + departmentId));
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        try {
            departmentJpaRepository.deleteById(departmentId);
        } catch (Exception exception) {
            throw new RecordNotFoundException("Not found department with id = " + departmentId);
        }
    }

    @Override
    public DepartmentDto getDepartmentByIdWithEmployeeNumber(Long departmentId) {
        try {
            DepartmentDto departmentDto = mybatisRepository.findDepartmentById(departmentId);
            if (!departmentDto.getDepartmentId().equals(departmentId)) throw new RecordNotFoundException("Not found department with id = " + departmentId);
            return departmentDto;
        } catch (Exception exception) {
            throw new RecordNotFoundException("Not found department with id = " + departmentId);
        }

    }
}
