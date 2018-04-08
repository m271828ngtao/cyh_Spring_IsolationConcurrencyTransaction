package com.cyh.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeServiceTest {

    private static ApplicationContext context;
    private static EmployeeService    employeeService;

    public static void main(String[] args) {
        new EmployeeServiceTest().run();
    }

    private void run() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        employeeService = context.getBean(EmployeeService.class);

        final int type = 1;
        if (type == 0) {
            reduceMoney();
        } else if (type == 1) {
            reduceMoneyWithPessimisticLock();
        } else if (type == 2) {

        }
    }

    private void reduceMoney() {
        int threadCount = 100;
        while (threadCount-- > 0) {
            new Thread(() -> employeeService.reduceMoney(1)).start();
        }
    }

    private void reduceMoneyWithPessimisticLock() {
        int threadCount = 100;
        while (threadCount-- > 0) {
            new Thread(() -> employeeService.reduceMoneyWithPessimisticLock(1)).start();
        }
    }

}
