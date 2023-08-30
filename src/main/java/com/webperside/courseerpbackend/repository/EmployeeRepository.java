package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.employee.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {

    void insert(Employee employee);
}
