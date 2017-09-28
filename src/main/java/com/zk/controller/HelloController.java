package com.zk.controller;

/**
 * Created by mj on 2017/7/14.
 */

import com.zk.pojo.User;
import com.zk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 测试
 *
 * @version v.0.1
 * @authorAngel(QQ:412887952)
 */

@Controller
public class HelloController {

    private String hello = "abc";
    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public ModelAndView helloJsp() {
        List<User> list = userService.query();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hello", hello);
        map.put("list", list);
        return new ModelAndView("helloJsp", map);
    }

    @RequestMapping("/hello2")
    public ModelAndView helloJsp2(Map<String, Object> map) {
        System.out.println("HelloController.helloJsp().hello=" + hello);
        map.put("hello", hello);
        return new ModelAndView("helloJsp");
    }

    @RequestMapping("/hello3")
    public ModelAndView helloJsp3(Model model) {
        System.out.println("HelloController.helloJsp().hello=" + hello);
        model.addAttribute("hello", hello);
        return new ModelAndView("helloJsp");
    }

    @RequestMapping("/hello4")
    public String helloJsp4(Model model) {
        List<User> list = userService.query();
        model.addAttribute("list", list);
        return model.toString();
    }
}
