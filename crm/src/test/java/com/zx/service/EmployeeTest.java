package com.zx.service;

import com.zx.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeTest {

        @Autowired
        private EmployeeService employeeService;

        @Test
        public void testfindAll() throws Exception {
            List<Employee> list = employeeService.findAll();
            System.out.println(list);
        }


        @Test
        public void testsave() throws Exception {
            Employee employee = new Employee();
            employee.setEmp_name("老z");
            employee.setDept_id(2);
            employee.setJob_name("保洁");

            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());

            employee.setJoin_date(date);
            employee.setTelephone("13312345678");


            employeeService.save(employee);
        }

}
