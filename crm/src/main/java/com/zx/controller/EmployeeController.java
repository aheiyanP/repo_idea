package com.zx.controller;

import com.zx.domain.Employee;
import com.zx.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /*
        查询所有员工
     */
    @RequestMapping("/findAll")
    public  String findAll(Model model){

        //实现查询所有账户
        List<Employee> list = employeeService.findAll();

        // 把封装好的list存到model中
        model.addAttribute("list",list);

        return "list";

    }

    /*
        添加员工
    */
    @RequestMapping("/save")
    public String save(Employee employee){

        employeeService.save(employee);
        // 跳转到findAll方法从新查询一次数据库进行数据的遍历展示
        return "redirect:/employee/findAll";
    }

    /*
            根据部门查询员工
        */
    @RequestMapping("/findByDid")
    public String findByDid(Integer did,Model model){

        System.out.println("部门id"+did);

        List<Employee> list = employeeService.findByDid(did);

        System.out.println("员工列表"+list);

        // 把封装好的list存到model中
        model.addAttribute("list",list);

        return "list";
    }


}
