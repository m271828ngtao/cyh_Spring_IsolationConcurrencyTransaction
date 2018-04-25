package com.cyh.service;

public class EmployeeServiceTest2 extends BaseTest {

    public static void main(String[] args) {
        new EmployeeServiceTest2().run();
    }

    private void run() {
        increaseMoneyWithPessimisticLock();
    }

    private void increaseMoneyWithPessimisticLock() {
        int threadCount = 100;
        while (threadCount-- > 0) {
            new Thread(() -> employeeService.increaseMoneyWithPessimisticLock(1)).start();
        }
    }

}
