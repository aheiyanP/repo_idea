package com.zx.service;

import com.zx.domain.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public void save(Employee employee);

    public List<Employee> findByDid(Integer did);
}
