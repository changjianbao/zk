package com.zk.controller;

import com.zk.pojo.User;
import com.zk.service.UserService;
import com.zk.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by mj on 2017/7/17.
 */

//@RestController
public class UserController {

//    @Autowired
//    UserService userService;

//    @RequestMapping(value="/" , method = RequestMethod.GET)
//    public ModelAndView query() {
//        List<User> list = userService.query();
//        ModelAndView mv =new ModelAndView("queryAll");
//        mv.addObject("list",list);
//        mv.addObject("a", "7889");
//        return mv;
//    }
//    @RequestMapping(value="/findbyage" , method = RequestMethod.GET)
//    public ModelAndView findByAge() {
//        List<User> list = userService.findByAge(12);
//        ModelAndView mv =new ModelAndView("queryAll");
//        mv.addObject("list",list);
//        mv.addObject("a", "7889");
//        return mv;
//    }
//    @RequestMapping(value="/gouploadimg", method = RequestMethod.GET)
//    public ModelAndView goUploadImg() {
//        ModelAndView mv =new ModelAndView("uploadimg");
//        return mv;
//    }
//
//    //处理文件上传
//    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
//    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
//        String contentType = file.getContentType();
//        String fileName = file.getOriginalFilename();
//        System.out.println("fileName-->" + fileName);
//        System.out.println("getContentType-->" + contentType);
//        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
//        try {
//            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//        //返回json
//        return "uploadimg success";
//    }
}
