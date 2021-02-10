package com.zx.dao;

import com.zx.domain.Employee;

import java.util.List;

public interface EmployeeDao {

    //根据dept_id查询相关员工
    public List<Employee> findByDid(Integer did);

    //查询所有员工
    public List<Employee> findAll();

    //保存员工
    public void save(Employee employee);
}
