package com.zk.service.impl;

import com.zk.dao.system.MenuDao;
import com.zk.pojo.Menu;
import com.zk.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MenuService
 * Created by mj on 2017/7/17
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    /**
     * 查询列表数据
     * @return
     */
    @Override
    public List<Menu> list() {
        return this.menuDao.list();
    }

    /**
     * 根据ID获取
     * @param id
     * @return
     */
    @Override
    public Menu findById(Integer id) {
        return this.menuDao.findById(id);
    }

    /**
     * 新增
     * @param menu
     * @return
     */
    @Override
    public int insert(Menu menu) {
        return this.menuDao.insert(menu);
    }

    /**
     * 编辑
     * @param menu
     */
    @Override
    public void update(Menu menu) {
        this.menuDao.update(menu);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id) {
        this.menuDao.delete(id);
    }
}
