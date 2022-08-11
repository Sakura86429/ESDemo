package com.zhj.esdemo.service;

import com.zhj.esdemo.pojo.User;
import com.zhj.esdemo.pojo.UserBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUserList();   // 接口默认方法是public abstract类型的

    User LoginIn(String username, String userpassword);
}
