package com.zk.service.impl;

import com.zk.dao.system.LoginDao;
import com.zk.pojo.Login;
import com.zk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * LoginService实现层
 * Created by mj on 2017/7/17
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    /**
     * 查询所有数据列表
     * @return
     */
    @Override
    public List<Login> list() {
        return loginDao.list();
    }
    /**
     * 根据ID查询一条记录
     * @param id
     * @return
     */
    @Override
    public Login findById(Integer id) {
        return loginDao.findById(id);
    }

    /**
     * 根据用户名查询用户实体
     * @param login
     * @return
     */
    @Override
    public Login findUserByUsername(Login login) {
        return loginDao.findUserByUsername(login);
    }

    /**
     * 查询相同用户名是否存在多条记录
     * @param login
     * @return
     */
    @Override
    public Login findDuplicateName(Login login) {
        return loginDao.findDuplicateName(login);
    }

    /**
     * 新增
     * @param user
     * @return
     */
    @Override
    public int insert(Login user) {
        return loginDao.insert(user);
    }

    /**
     * 更新
     * @param user
     */
    @Override
    public void update(Login user) {
        loginDao.update(user);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id) {
        loginDao.delete(id);
    }
}
