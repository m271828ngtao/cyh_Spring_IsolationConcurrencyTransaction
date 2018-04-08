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

    /**
     * 乐观锁：解决并发问题
     * 需要在实体类中添加一个 Version 字段
     * @param employee
     * @return Integer 表示成功更新的行数。如果为0表示更新失败，这也是后续程序判断的依据
     */
    Integer updateEmployeeWithOptimisticLock(@Param("e") Employee employee);
}
