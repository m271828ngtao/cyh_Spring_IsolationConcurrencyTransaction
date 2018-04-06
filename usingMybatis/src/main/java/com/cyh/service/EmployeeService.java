package com.cyh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyh.dao.EmployeeMapper;
import com.cyh.entity.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    public void reduceMoney(Integer id) {
        Employee employee = employeeMapper.findById(id);
        employee.setMoney(employee.getMoney() - 10);
        employeeMapper.updateEmployee(employee);
    }

}
