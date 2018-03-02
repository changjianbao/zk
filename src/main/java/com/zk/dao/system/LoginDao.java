package com.zk.dao.system;

import com.zk.pojo.Login;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统用户相关Dao
 * Created by mj on 2017/7/17.
 */

@Mapper
public interface LoginDao {
    List<Login> list();
    Login findById(Integer id);
    Login findUserByUsername(Login login);
    Login findDuplicateName(Login login);
    int insert(Login user);
    int update(Login user);
    int delete(Integer id);
}
