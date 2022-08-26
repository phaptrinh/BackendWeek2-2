package com.example.week22.service.impl;

import com.example.week22.exception.RecordNotFoundException;
import com.example.week22.payload.BaseResponse;
import com.example.week22.payload.dto.EmployeeDto;
import com.example.week22.entity.Employee;
import com.example.week22.payload.dto.EmployeeDtoV2;
import com.example.week22.repository.EmployeeJpaRepository;
import com.example.week22.repository.MybatisRepository;
import com.example.week22.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeJpaRepository employeeJpaRepository;

    @Resource
    MybatisRepository mybatisRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        try {
            return modelMapper.map(employeeJpaRepository.save(employee), EmployeeDto.class);
        } catch (Exception e) {
            throw new RecordNotFoundException("Not found department with id = " + employeeDto.getDepartmentId());
        }
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Optional<Employee> employee = employeeJpaRepository.findById(employeeId);
        try {
            return modelMapper.map(employee.get(), EmployeeDto.class);
        } catch (Exception e) {
            throw new RecordNotFoundException("Not found employee with id = " + employeeId);
        }
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        try {
            employeeJpaRepository.deleteById(employeeId);
        } catch (Exception e) {
            throw new RecordNotFoundException("Not found employee with id = " + employeeId);

        }

    }

    @Override
    public EmployeeDtoV2 getEmployeeByIdV2(Long employeeId) {
        EmployeeDtoV2 employeeDtoV2 = mybatisRepository.findEmployeeById(employeeId);
        if (employeeDtoV2 == null) throw new RecordNotFoundException("Not found employee with id = " + employeeId);
        return employeeDtoV2;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeJpaRepository.findAll().stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }
}
