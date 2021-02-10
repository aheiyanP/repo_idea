package com.zx.service.imp;

import com.zx.dao.EmployeeDao;
import com.zx.domain.Employee;
import com.zx.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    //查询员工
    @Override
    public List<Employee> findAll() {
        System.out.println("\"findAll执行了....");
        return employeeDao.findAll();
    }

    //添加员工
    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public List<Employee> findByDid(Integer did) {
        return employeeDao.findByDid(did);
    }
}
