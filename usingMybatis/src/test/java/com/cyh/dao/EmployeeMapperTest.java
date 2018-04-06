package com.cyh.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cyh.entity.Employee;

public class EmployeeMapperTest {

    private static ApplicationContext context;
    private static EmployeeMapper employeeMapper;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        employeeMapper = context.getBean(EmployeeMapper.class);
    }

    @Test
    public void findById() throws Exception {
        Employee employee = employeeMapper.findById(1);
        System.out.println(employee);
    }

    @Test
    public void reduceMoney() throws Exception {
        employeeMapper.reduceMoney(1, 10);
    }

    @Test
    public void increaseMoney() throws Exception {
        employeeMapper.increaseMoney(1, 20);
    }

}
