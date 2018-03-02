package com.zk.controller;

import com.alibaba.fastjson.JSONObject;
import com.zk.pojo.Login;
import com.zk.pojo.Menu;
import com.zk.pojo.MenuJsonTreeData;
import com.zk.service.LoginService;
import com.zk.service.MenuService;
import com.zk.util.EncoderByMd5;
import com.zk.util.TreeNodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户登陆
 * Created by mj on 2017/7/17.
 */

@Controller
@RequestMapping(value="/")
public class IndexController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private MenuService menuService;

    /**
     * 前往登录页
     * @return
     */
    @RequestMapping(value="/")
    public ModelAndView login() {
        ModelAndView mv =new ModelAndView("login.html");
        return mv;
    }

    /**
     * 登陆
     * @param login
     * @return
     */
    @RequestMapping(value="/doLogin")
    public @ResponseBody JSONObject doLogin(HttpServletRequest request, Login login) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //返回结果
        JSONObject result=new JSONObject();
        result.put("status",0);
        if(login.getUsername()!=null&&login.getPassword()!=null
                &&!login.getUsername().trim().equals("")&&!login.getPassword().trim().equals("")){
            Login login1 = loginService.findUserByUsername(login);
            if(login1!=null){
                if(EncoderByMd5.EncoderByMd5(login.getPassword())
                        .equalsIgnoreCase(login1.getPassword())){
                    //存入session
                    request.getSession().setAttribute("login",login1);
                    result.put("status",1);
                }else{
                    result.put("msg","用户名或密码错误");
                }
            }else{
                result.put("msg","用户名或密码错误");
            }
        }else{
            result.put("msg","请输入用户名和密码");
        }
        return result;
    }

    /**
     * 获取菜单
     * @return
     */
    @RequestMapping(value="/getMenu", method = RequestMethod.GET)
    public @ResponseBody Object getMenu() {
        List<MenuJsonTreeData> treeDataList=new ArrayList<MenuJsonTreeData>();
        List<Menu> menuList=menuService.list();
        if(menuList!=null&&menuList.size()>0){
            for(Menu menu : menuList){
                MenuJsonTreeData menuJsonTreeData = new MenuJsonTreeData();
                menuJsonTreeData.setId(menu.getId()+"");
                menuJsonTreeData.setSpread(false);
                menuJsonTreeData.setPid(menu.getParentId()+"");
                menuJsonTreeData.setTitle(menu.getName());
                menuJsonTreeData.setUrl(menu.getUrl());
                menuJsonTreeData.setIcon(menu.getMenuIcon());
                treeDataList.add(menuJsonTreeData);
            }
        }
        treeDataList= TreeNodeUtil.getfatherNode(treeDataList);
        return JSONObject.toJSON(treeDataList);
    }

}
