package com.zhj.esdemo;

import com.zhj.esdemo.pojo.User;
import com.zhj.esdemo.pojo.UserBean;
import com.zhj.esdemo.service.Impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/26 18:10
 */
public class MysqlTests {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void serviceTest() {
//        UserBean userBean = userService.LoginIn("张三","000000");
        List<User> user = userService.getUserList();
        for (User u : user) {
            System.out.println(u.getUsername());
        }
        if (user == null) System.out.println("null user");
        System.out.println("该用户ID为：");
        System.out.println(user);
    }
}
