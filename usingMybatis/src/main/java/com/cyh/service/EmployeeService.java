package com.cyh.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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

    @Transactional(rollbackFor = RuntimeException.class)
    public void reduceMoneyWithPessimisticLock(Integer id) {
        Employee employee = employeeMapper.findByIdWithPessimisticLock(id);
        employee.setMoney(employee.getMoney() - 10);
        employeeMapper.updateEmployee(employee);
    }

    /**
     * 失败尝试
     * @param id
     */
    public void reduceMoneyWithOptimisticLock(Integer id) {
        int tryTimes = 0;
        while (true) {
            tryTimes++;
            if (internalReduceMoneyWithOptimisticLock(id) != 0) {
                // 说明更新成功，直接退出
                break;
            }
            if (tryTimes == 200) {
                // 达到最大重试次数，退出
                break;
            }
            try {
                // 休息一段时间后再重试
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " tryTimes: " + tryTimes);
    }

    /**
     * 查找Employee对象，并进行更新
     * @param id
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public Integer internalReduceMoneyWithOptimisticLock(Integer id) {
        Employee employee = employeeMapper.findById(id);
        employee.setMoney(employee.getMoney() - 10);
        employee.setVersion(employee.getVersion() + 1);
        return employeeMapper.updateEmployeeWithOptimisticLock(employee);
    }

}
