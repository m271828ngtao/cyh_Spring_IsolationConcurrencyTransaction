package com.cyh.service;

public class EmployeeServiceTest extends BaseTest {

    public static void main(String[] args) {
        new EmployeeServiceTest().run();
    }

    private void run() {
        increaseMoney();
    }

    private void increaseMoney() {
        int threadCount = 100;
        while (threadCount-- > 0) {
            new Thread(() -> employeeService.increaseMoney(1)).start();
        }
    }

}
