package com.example.week22.repository;

import com.example.week22.payload.dto.DepartmentDto;
import com.example.week22.payload.dto.EmployeeDtoV2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MybatisRepository {

    @Select("SELECT D.DEPARTMENT_ID, DEPT_NAME, DESCIPTION, COUNT(*) EMPLOYEENUM FROM DEPARTMENT D JOIN EMPLOYEE E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID WHERE D.DEPARTMENT_ID = #{departmentId}")
    @Results(value = {@Result(property = "departmentId", column = "DEPARTMENT_ID"),
            @Result(property = "deptName", column = "DEPT_NAME"),
            @Result(property = "desciption", column = "DESCIPTION"),
            @Result(property = "employeeNum", column = "EMPLOYEENUM")}
    )
    DepartmentDto findDepartmentById(Long departmentId);

    @Select("SELECT E.*, DEPT_NAME, DESCIPTION FROM DEPARTMENT D JOIN EMPLOYEE E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID WHERE EMPLOYEE_ID = #{employeeId}")
    @Results(value = {@Result(property = "employeeId", column = "EMPLOYEE_ID"),
            @Result(property = "name", column = "NAME"),
            @Result(property = "birthDate", column = "BIRTH_DATE"),
            @Result(property = "gender", column = "GENDER"),
            @Result(property = "departmentId", column = "DEPARTMENT_ID"),
            @Result(property = "deptName", column = "DEPT_NAME"),
            @Result(property = "desciption", column = "DESCIPTION")}
    )
    EmployeeDtoV2 findEmployeeById(Long employeeId);
}
