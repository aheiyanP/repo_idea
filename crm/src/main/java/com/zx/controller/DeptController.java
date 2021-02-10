package com.zx.controller;

import com.zx.domain.Dept;
import com.zx.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /*
        查询所有部门
     */

    @RequestMapping("/ajaxRequest")
    @ResponseBody
    public List<Dept> ajaxRequest(){

        System.out.println("ajaxRequest执行了....");
        //实现查询所有部门
        List<Dept> list = deptService.findAll();
        System.out.println(list);

        return list;

    }

}
