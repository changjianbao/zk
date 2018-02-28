package com.zk.dao;

import com.zk.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/** extends JpaRepository<User,Integer>
 * Created by mj on 2017/7/17.
 */
//@Mapper
public interface UserMapper{
    @Select("select * from user")
    List<User> query();
    @Select("select * from user where age=#{age}")
    List<User> findByAge(Integer age);
//    @Query(value="select u from user u where u.age=?1")
//    List<User> findByAge(Integer age);
}
