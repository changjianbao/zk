package com.zk.dao;

import com.zk.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by mj on 2017/7/17.
 */

@Mapper
public interface UserDao {
    List<User> query();
}
