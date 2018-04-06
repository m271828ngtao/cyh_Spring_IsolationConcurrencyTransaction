package com.cyh.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeServiceTest {

    public static void main(String[] args) {
        new EmployeeServiceTest().run();
    }

    private ApplicationContext context;
    private EmployeeService employeeService;

    private void run() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        employeeService = context.getBean(EmployeeService.class);

        reduceMoney();
        increaseMoney();
    }


    public void reduceMoney() {
        int threadCount = 100;
        while (threadCount-- > 0) {
            new Thread(() -> employeeService.reduceMoney()).start();
        }
    }


    public void increaseMoney() {
        int threadCount = 100;
        while (threadCount-- > 0) {
            new Thread(() -> employeeService.increaseMoney()).start();
        }
    }

}
