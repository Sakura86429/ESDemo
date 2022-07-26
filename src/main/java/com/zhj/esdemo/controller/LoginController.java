package com.zhj.esdemo.controller;

import com.zhj.esdemo.pojo.User;
import com.zhj.esdemo.pojo.UserBean;
import com.zhj.esdemo.service.ContentService;
import com.zhj.esdemo.service.Impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/26 21:29
 */
@Slf4j
@Controller
public class LoginController {

    //将Service注入Web层
//    @Resource
    @Autowired
    UserServiceImpl userService;

    //实现登录
    @RequestMapping({"/","/login"})
    public String show(){
        List<User> user = userService.getUserList();

        for (User u : user) {
            System.out.println(u.getUsername());
        }
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name,String password){
        System.out.println(name);
        System.out.println(password);
        User userBean = userService.LoginIn(name, password);
        System.out.println(userBean.getUsername());
        System.out.println(userBean.getUserpassword());
        log.info("name:{}",name);
        log.info("password:{}",password);
        if(userBean!=null){
//            return "success";
//            return "index";
//            return "signup";
            return "index";
        }else {
            return "error";
        }
    }

    //    @GetMapping({"/","/index"})
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
//    @RequestMapping("/signup")
//    public String disp(){
//        return "signup";
//    }

    //实现注册功能
//    @RequestMapping(value = "/register",method = RequestMethod.POST)
//    public String signUp(String name,String password){
//        userService.Insert(name, password);
//        return "success";
//    }

}
