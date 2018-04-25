/*
 * GuoXiaoMei.com Inc.
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package com.cyh.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {

    protected static ApplicationContext context;
    protected static EmployeeService    employeeService;

    static {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        employeeService = context.getBean(EmployeeService.class);
    }
}
