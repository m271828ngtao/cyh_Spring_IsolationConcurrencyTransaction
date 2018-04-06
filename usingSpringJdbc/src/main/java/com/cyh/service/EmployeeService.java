package com.cyh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author CYH
 *
 * 这种写法是可以的
 */
@Service
public class EmployeeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Transactional(rollbackFor = RuntimeException.class)
    public void reduceMoney() {
        String sql = "UPDATE employee SET money = money - 10 where id = 1";
        jdbcTemplate.update(sql);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void increaseMoney() {
        String sql = "UPDATE employee SET money = money + 20 where id = 1";
        jdbcTemplate.update(sql);
    }


}
