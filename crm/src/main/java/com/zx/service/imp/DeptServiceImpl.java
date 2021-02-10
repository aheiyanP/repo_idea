package com.zx.service.imp;


import com.zx.dao.DeptDao;
import com.zx.domain.Dept;
import com.zx.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
