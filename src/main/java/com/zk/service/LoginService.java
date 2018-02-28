package com.zk.service;

import com.zk.pojo.Login;

import java.util.List;

/**
 * Created by mj on 2017/7/17.
 */
public interface LoginService {
    List<Login> list();
    Login findById(Integer id);
    int insert(Login user);
    void update(Login user);
    void delete(Integer id);
}
