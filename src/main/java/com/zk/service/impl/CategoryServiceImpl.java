package com.zk.service.impl;

import com.zk.dao.system.CategoryDao;
import com.zk.pojo.Category;
import com.zk.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * LoginService实现层
 * Created by mj on 2017/7/17
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    @Override
    public Integer count(HashMap map) {
        return categoryDao.count(map);
    }

    @Override
    public List<Category> list(HashMap map) {
        return categoryDao.list(map);
    }

    @Override
    public Category findById(Integer id) {
        return categoryDao.findById(id);
    }

    @Override
    public Category findDuplicateName(Category category) {
        return categoryDao.findDuplicateName(category);
    }

    @Override
    public Category findByName(Category category) {
        return categoryDao.findByName(category);
    }

    @Override
    public Integer insert(Category category) {
        return categoryDao.insert(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void delete(Integer id) {
        categoryDao.delete(id);
    }

    @Override
    public void batchDelete(List<Integer> idList) {
        categoryDao.batchDelete(idList);
    }
}
