package com.zk.service;

import com.zk.pojo.Login;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mj on 2017/7/17.
 */
public interface LoginService {
    List<Login> list(HashMap map);
    Login findById(Integer id);
    Login findUserByUsername(Login login);
    Login findDuplicateName(Login login);
    int insert(Login user);
    void update(Login user);
    void delete(Integer id);
}
