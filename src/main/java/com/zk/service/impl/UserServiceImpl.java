package com.zk.service.impl;

import com.zk.dao.UserDao;
import com.zk.dao.UserMapper;
import com.zk.pojo.User;
import com.zk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mj on 2017/7/17
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> query() {
        return userMapper.query();
    }

    @Override
    public List<User> findByAge(Integer age) {
        return userMapper.findByAge(age);
//        return null;
    }
}
