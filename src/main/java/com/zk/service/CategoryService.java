package com.zk.service;

import com.zk.pojo.Category;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mj on 2017/7/17.
 */
public interface CategoryService {
    Integer count(HashMap map);
    List<Category> list(HashMap map);
    Category findById(Integer id);
    Category findDuplicateName(Category category);
    Category findByName(Category category);
    Integer insert(Category category);
    void update(Category category);
    void delete(Integer id);
    void batchDelete(List<Integer> idList);
}
