package com.zk.dao.system;

import com.zk.pojo.Login;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 系统用户相关Dao
 * Created by mj on 2017/7/17.
 */

@Mapper
public interface LoginDao {
    Integer count(HashMap map);
    List<Login> list(HashMap map);
    Login findById(Integer id);
    Login findUserByUsername(Login login);
    Login findDuplicateName(Login login);
    Integer insert(Login user);
    void update(Login user);
    void delete(Integer id);
}
