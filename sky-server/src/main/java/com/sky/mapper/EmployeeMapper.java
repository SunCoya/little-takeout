package com.sky.mapper;
import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    //根据用户名查询员工
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);


    @AutoFill(OperationType.INSERT)
    @Insert("INSERT INTO employee(name, username, password, phone, sex, id_number, status, create_time, update_time, create_user, update_user)" +
            " values (#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void insert(Employee employee);

    //也能返回page（继承List）
    Page<Employee> selectByCondition(String name);

    @AutoFill(OperationType.UPDATE)
    void update(Employee employee);

    //TODO 这里能不能和上面的select合并成一个方法呢？
    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);
}
