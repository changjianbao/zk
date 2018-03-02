package com.zk.controller;

import com.alibaba.fastjson.JSONObject;
import com.zk.pojo.Login;
import com.zk.service.LoginService;
import com.zk.util.EncoderByMd5;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
     * 编辑
     * @param login
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value="/edit")
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
                login.setPassword(EncoderByMd5.EncoderByMd5(login.getPassword()));
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
}
