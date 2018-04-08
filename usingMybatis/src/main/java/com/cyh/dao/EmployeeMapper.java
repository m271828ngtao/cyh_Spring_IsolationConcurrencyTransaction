package com.cyh.dao;

import org.apache.ibatis.annotations.Param;

import com.cyh.entity.Employee;

public interface EmployeeMapper {

    Employee findById(@Param("id") Integer id);

    /**
     * 悲观锁：解决并发问题
     * 其实就是在 Select 语句中添加了 FOR UPDATE
     * @param id
     * @return
     */
    Employee findByIdWithPessimisticLock(@Param("id") Integer id);

    void reduceMoney(@Param("id") Integer id, @Param("number") Integer number);

    void increaseMoney(@Param("id") Integer id, @Param("number") Integer number);

    void updateEmployee(@Param("e") Employee employee);
}
