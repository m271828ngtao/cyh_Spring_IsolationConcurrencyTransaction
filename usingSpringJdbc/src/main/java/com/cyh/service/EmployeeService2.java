package com.cyh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author CYH
 *
 * 这种写法有问题，还没想通是为什么？？？？
 */
@Service
public class EmployeeService2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 这种写法有问题：多线程访问时，得不到正确结果，为什么？
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void reduceMoney() {
        String sql = "SELECT money FROM employee where id = 1";
        Integer money = jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);

        sql = "UPDATE employee SET money = ? - 10 where id = 1";
        jdbcTemplate.update(sql, money);
    }

    /**
     * 这种写法有问题：多线程访问时，得不到正确结果，为什么？
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void increaseMoney() {
        String sql = "SELECT money FROM employee where id = 1";
        Integer money = jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);

        sql = "UPDATE employee SET money = ? + 20 where id = 1";
        jdbcTemplate.update(sql, money);
    }

}
