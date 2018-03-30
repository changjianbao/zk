package com.zk.controller;

import com.alibaba.fastjson.JSONObject;
import com.zk.pojo.Login;
import com.zk.service.LoginService;
import com.zk.util.EncoderByMd5;
import com.zk.util.TableData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 用户管理
 * Created by mj on 2017/7/17.
 */

@Controller
@RequestMapping(value="/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 前往用户列表页面
     * @return
     */
    @RequestMapping(value="/list")
    public ModelAndView list() {
        ModelAndView mv =new ModelAndView("login/login_list");
        return mv;
    }
    /**
     * 前往用户编辑页面
     * @return
     */
    @RequestMapping(value="/edit")
    public ModelAndView edit(String id,Model model) {
        Login login = null;
        if(StringUtils.isNotBlank(id)&&StringUtils.isNumeric(id)){
            login = loginService.findById(Integer.parseInt(id));
        }else{
            login = new Login();
            login.setSex(1);
        }
        model.addAttribute("login",login);
        ModelAndView mv =new ModelAndView("login/login_edit");
        return mv;
    }
    /**
     * 查询列表数据
     * @return
     */
    @RequestMapping(value="/getList")
    public @ResponseBody Object getList(String page,String limit) {
        //返回结果
        JSONObject result=new JSONObject();
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
        int count=loginService.count(map);
        //查询列表数据
        List<Login> list = loginService.list(map);
        JSONObject obj=TableData.getLayUITable(0, "", count, list);
        return obj;
    }
    /**
     * 编辑保存
     * @param login
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value="/save")
    public @ResponseBody JSONObject list(Login login) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //返回结果
        JSONObject result=new JSONObject();
        result.put("status",0);
        if(login.getId()!=null){//编辑
            Login duplicateLogin=loginService.findDuplicateName(login);
            if(duplicateLogin==null){
                login.setPassword(EncoderByMd5.EncoderByMd5(login.getPassword()));
                loginService.update(login);
            }else{
                result.put("msg","用户名或者电话已经存在;请重新填写");
            }
        }else{//新增
            Login duplicateLogin=loginService.findUserByUsername(login);
            if(duplicateLogin!=null){
                result.put("msg","用户名或者电话已经存在;请重新填写");
            }else{
                if(StringUtils.isNotBlank(login.getPassword())){
                    login.setPassword(EncoderByMd5.EncoderByMd5(login.getPassword()));
                }else{
                    login.setPassword(EncoderByMd5.EncoderByMd5("123456"));
                }
                int i=loginService.insert(login);
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
            Login login = loginService.findById(Integer.parseInt(id));
            if(login!=null){
                result.put("status",1);
                result.put("login",login);
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
            loginService.delete(Integer.parseInt(id));
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
                loginService.batchDelete(idList);
                result.put("status",1);
                result.put("msg","操作成功");
            }
        }else{
            result.put("msg","操作失败ID不能为空");
        }
        return result;
    }
}
