package com.zk.dao.system;

import com.zk.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单相关Dao
 * Created by mj on 2017/7/17.
 */

@Mapper
public interface MenuDao {
    List<Menu> list();
    Menu findById(Integer id);
    int insert(Menu menu);
    int update(Menu menu);
    int delete(Integer id);
}
