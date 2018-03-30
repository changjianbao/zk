package com.zk.controller;

import com.alibaba.fastjson.JSONObject;
import com.zk.pojo.Category;
import com.zk.service.CategoryService;
import com.zk.util.TableData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 类目管理
 * Created by mj on 2017/7/17.
 */

@Controller
@RequestMapping(value="/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 前往列表页面
     * @return
     */
    @RequestMapping(value="/list")
    public ModelAndView list() {
        ModelAndView mv =new ModelAndView("category/category_list");
        return mv;
    }
    /**
     * 前往编辑页面
     * @return
     */
    @RequestMapping(value="/edit")
    public ModelAndView edit(String id,Model model) {
        Category category = null;
        if(StringUtils.isNotBlank(id)&&StringUtils.isNumeric(id)){
            category = categoryService.findById(Integer.parseInt(id));
        }else{
            category = new Category();
        }
        model.addAttribute("category",category);
        ModelAndView mv =new ModelAndView("category/category_edit");
        return mv;
    }
    /**
     * 查询列表数据
     * @return
     */
    @RequestMapping(value="/getList")
    public @ResponseBody Object getList(String page,String limit) {
        //分页
        Integer start=0;
        if(page!=null){
            start=(Integer.parseInt(page)-1)*Integer.parseInt(limit);
        }
        Integer length=10;
        if(limit!=null){
            length=Integer.parseInt(limit);
        }
        HashMap map = new HashMap();
        map.put("start",start);
        map.put("length",length);
        //查询总条数
        int count=categoryService.count(map);
        //查询列表数据
        List<Category> list = categoryService.list(map);
        return TableData.getLayUITable(0, "", count, list);
    }
    /**
     * 编辑保存
     * @param category
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value="/save")
    public @ResponseBody JSONObject list(Category category) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //返回结果
        JSONObject result=new JSONObject();
        result.put("status",0);
        if(category.getId()!=null){//编辑
            Category duplicateCategory=categoryService.findDuplicateName(category);
            if(duplicateCategory==null){
                result.put("msg","类目名称已经存在;请重新填写");
            }
        }else{//新增
            Category duplicatecategory=categoryService.findByName(category);
            if(duplicatecategory!=null){
                result.put("msg","类目名称已经存在;请重新填写");
            }else{
                int i=categoryService.insert(category);
                if(i>0){
                    result.put("status",1);
                    result.put("msg","添加成功");
                }else{
                    result.put("msg","添加失败");
                }
            }
        }
        return result;
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value="/findById")
    public @ResponseBody JSONObject findById(String id) {
        //返回结果
        JSONObject result=new JSONObject();
        result.put("status",0);
        //根据ID查询一条记录
        if(!StringUtils.isBlank(id)&&StringUtils.isNumeric(id)){
            Category category = categoryService.findById(Integer.parseInt(id));
            if(category!=null){
                result.put("status",1);
                result.put("category",category);
            }else{
                result.put("msg","该条记录不存在");
            }
        }else{
            result.put("msg","操作失败ID不能为空");
        }
        return result;
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @RequestMapping(value="/del")
    public @ResponseBody JSONObject del(String id) {
        //返回结果
        JSONObject result=new JSONObject();
        result.put("status",0);
        //根据ID查询一条记录
        if(!StringUtils.isBlank(id)&&StringUtils.isNumeric(id)){
            categoryService.delete(Integer.parseInt(id));
            result.put("status",1);
            result.put("msg","操作成功");
        }else{
            result.put("msg","操作失败ID不能为空");
        }
        return result;
    }

    /**
     * 根据ID批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value="/batchDelete")
    public @ResponseBody JSONObject batchDelete(String ids) {
        //返回结果
        JSONObject result=new JSONObject();
        boolean flag=true;
        result.put("status",0);
        //根据ID查询一条记录
        if(!StringUtils.isBlank(ids)){
            List<Integer> idList=new ArrayList<>();
            String[] idArr = ids.split(",");
            for(String sId : idArr){
                if(StringUtils.isNumeric(sId)){
                    idList.add(Integer.parseInt(sId));
                }else{
                    result.put("msg","操作失败;< "+sId+" >非数字");
                }
            }
            if(flag){
                categoryService.batchDelete(idList);
                result.put("status",1);
                result.put("msg","操作成功");
            }
        }else{
            result.put("msg","操作失败ID不能为空");
        }
        return result;
    }
}
