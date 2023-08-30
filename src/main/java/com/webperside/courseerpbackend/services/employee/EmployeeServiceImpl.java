package com.webperside.courseerpbackend.services.employee;

import com.webperside.courseerpbackend.models.mybatis.employee.Employee;
import com.webperside.courseerpbackend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public void insert(Employee employee) {
        employeeRepository.insert(employee);
    }
}
