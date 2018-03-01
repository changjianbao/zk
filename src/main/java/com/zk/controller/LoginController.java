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


    @RequestMapping(value="/list")
    public @ResponseBody JSONObject list() {
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
