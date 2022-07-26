package com.zhj.esdemo.service.Impl;

import com.zhj.esdemo.mapper.UserMapper;
import com.zhj.esdemo.pojo.User;
import com.zhj.esdemo.pojo.UserBean;
import com.zhj.esdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/26 20:16
 */


@Repository
public class UserServiceImpl implements UserService {
    //将dao层属性注入service层
    @Autowired
    private UserMapper userMapper;
    @Override
    public User LoginIn(String username, String userpassword) {
        System.out.println("start service");
//        System.out.println(userMapper.getInfo(name,password));
        List<User> userBean = userMapper.getUserList();
        for (User u : userBean) {
            System.out.println(u.getUsername());
        }
        return userMapper.getInfo(username,userpassword);
    }

//    public void Insert(String name,String password){
//        userMapper.saveInfo(name, password);
//    }
    @Override
    public List<User> getUserList() {
        try {
            List<User> users = userMapper.getUserList();

            return  users;
        }
        catch (Exception e)
        {
            throw e;
//            return null;
        }
    }
}
