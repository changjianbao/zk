package com.zk.service;

import com.zk.pojo.Menu;

import java.util.List;

/**
 * Created by mj on 2017/7/17.
 */
public interface MenuService {
    List<Menu> list();
    Menu findById(Integer id);
    int insert(Menu menu);
    void update(Menu menu);
    void delete(Integer id);
}
