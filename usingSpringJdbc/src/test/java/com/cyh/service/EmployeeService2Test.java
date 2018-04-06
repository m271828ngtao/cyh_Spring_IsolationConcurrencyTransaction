package com.cyh.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeService2Test {

    public static void main(String[] args) {
        new EmployeeService2Test().run();
    }

    private ApplicationContext context;
    private EmployeeService2 employeeService2;

    private void run() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        employeeService2 = context.getBean(EmployeeService2.class);

        reduceMoney();
        increaseMoney();
    }

    public void reduceMoney() {
        int threadCount = 100;
        while (threadCount-- > 0) {
            new Thread(() -> employeeService2.reduceMoney()).start();
        }
    }


    public void increaseMoney() {
        int threadCount = 100;
        while (threadCount-- > 0) {
            new Thread(() -> employeeService2.increaseMoney()).start();
        }
    }


}
