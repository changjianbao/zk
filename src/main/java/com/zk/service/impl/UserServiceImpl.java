package com.zk.service.impl;

import com.zk.dao.UserDao;
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

    @Override
    public List<User> query() {
        return userDao.query();
    }
}
