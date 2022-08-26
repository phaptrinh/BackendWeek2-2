package com.example.week22.repository;

import com.example.week22.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentJpaRepository extends JpaRepository<Department, Long> {
}
