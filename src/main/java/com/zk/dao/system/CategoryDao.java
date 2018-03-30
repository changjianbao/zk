package com.zk.dao.system;

import com.zk.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 服务类目分组相关Dao
 * Created by mj on 2017/7/17.
 */

@Mapper
public interface CategoryDao {
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
