package com.zhj.esdemo;

import com.zhj.esdemo.mapper.UserMapper;
import com.zhj.esdemo.pojo.Content;
import com.zhj.esdemo.pojo.User;
import com.zhj.esdemo.service.Impl.UserServiceImpl;
//import org.junit.Test;
import com.zhj.esdemo.utils.Jdbc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/26 18:10
 */
@SpringBootTest
public class MysqlApiTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    void mapperUse() {   // 查询成功
        List<User> user = userMapper.getUserList();
        String name = "张三";
        String pwd = "123456";
        User user2 = userMapper.getInfo("张三", "123456");
    }

    @Test
    void inserUser() {
        userMapper.saveInfo("王五", "123456", 18, "女");
    }

    @Test
    void inserGoods() {

        long stime = System.currentTimeMillis(); // 统计开始时间
        List<Object> list = new ArrayList<>();
        Content content = new Content();
        content.setTitle("中国");
//        content.get
        content.setPrice("120");
        content.setImg("hajajklsdfjl");
        list.add(content);
        list.add(content);
        for (Object content1 : list) {
            Content con = (Content) content1;
            String title = con.getTitle();
            String price = con.getPrice();
            String img = con.getImg();
            userMapper.addGoods(title, price, img);
        }

        long etime = System.currentTimeMillis(); // 统计结束时间
        System.out.println("执行时间：" + (etime - stime));
    }

//    @Test
//    void serviceTest() {
////        UserBean userBean = userService.LoginIn("张三","000000");
//        List<User> user = userService.getUserList();
//        for (User u : user) {
//            System.out.println(u.getUsername());
//        }
//        if (user == null) System.out.println("null user");
//        System.out.println("该用户ID为：");
//        System.out.println(user);
//    }
}
