package com.cyh.service;

public class EmployeeServiceTest3 extends BaseTest {

    public static void main(String[] args) {
        new EmployeeServiceTest3().run();
    }

    private void run() {
        increaseMoneyWithOptimisticLock();
    }

    private void increaseMoneyWithOptimisticLock() {
        int threadCount = 100;
        while (threadCount-- > 0) {
            new Thread(() -> employeeService.increaseMoneyWithOptimisticLock(1)).start();
        }
    }

}
