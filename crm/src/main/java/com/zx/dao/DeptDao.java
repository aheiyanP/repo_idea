package com.zx.dao;

import com.zx.domain.Dept;

import java.util.List;

public interface DeptDao {

    //根据条件查询部门
    public List<Dept> findBy(Dept dept);

    //根查询所有员工
    public List<Dept> findAll();

    public List<Dept> findAllWithEmp();
}
