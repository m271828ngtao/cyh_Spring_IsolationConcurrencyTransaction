package com.cyh.dao;

import org.apache.ibatis.annotations.Param;

import com.cyh.entity.Employee;

public interface EmployeeMapper {

    Employee findById(@Param("id") Integer id);

    void reduceMoney(@Param("id") Integer id, @Param("number") Integer number);

    void increaseMoney(@Param("id") Integer id, @Param("number") Integer number);

    void updateEmployee(@Param("e") Employee employee);
}
