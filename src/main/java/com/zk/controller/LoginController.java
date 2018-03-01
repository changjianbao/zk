package com.zk.controller;

import com.alibaba.fastjson.JSONObject;
import com.zk.pojo.Login;
import com.zk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by mj on 2017/7/17.
 */

@Controller
@RequestMapping(value="/")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value="/")
    public ModelAndView login() {
        ModelAndView mv =new ModelAndView("login.html");
        return mv;
    }
    @RequestMapping(value="/doLogin")
    public @ResponseBody JSONObject doLogin(Login login) {
        //返回结果
        JSONObject result=new JSONObject();
        result.put("status",0);
        if(login.getUsername()!=null&&login.getPassword()!=null
                &&!login.getUsername().trim().equals("")&&!login.getPassword().trim().equals("")){
            Login login1 = loginService.findUserByUsername(login);
            if(login1!=null){
                result.put("status",1);
            }else{
                result.put("msg","用户名或密码错误");
            }
        }else{
            result.put("msg","请输入用户名和密码");
        }
        return result;
    }

    @RequestMapping(value="/edit")
    public @ResponseBody JSONObject list(Login login) {

        //返回结果
        JSONObject result=new JSONObject();
        //查询列表数据
        List<Login> list = loginService.list();
        result.put("list",list);

        return result;
    }
    @RequestMapping(value="/findById")
    public @ResponseBody JSONObject findById() {
        //返回结果
        JSONObject result=new JSONObject();
        //根据ID查询一条记录
        Login login = loginService.findById(12);
        result.put("login",login);

        return result;
    }


}
