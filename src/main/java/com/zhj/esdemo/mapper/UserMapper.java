package com.zhj.esdemo.mapper;


import com.zhj.esdemo.pojo.User;
import com.zhj.esdemo.pojo.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
//    查询，可以实现登录功能
//    @Select("select * from usertable where username = #{username} and userpassword = #{userpassword}")
    @Select("SELECT * FROM usertable WHERE username = #{username} AND userpassword = #{userpassword}")
    User getInfo(@Param("username") String username, @Param("userpassword") String userpassword);
//    UserBean getInfo(String name, String password);

    // 查询数据
    @Select("select * from usertable order by user_id desc")
//    @Select("select * from usertable where username=#{username}")
    List<User> getUserList();

//    // 查询数据
//    @Select("select * from usertable order by user_id desc")
//    List<UserBean> getUserList();


//    //多个参数要加@Param修饰
//    //增加，可以实现注册功能
//    @Insert("insert into user(name,password)values(#{name},#{password})")
//    void saveInfo(@Param("name") String name, @Param("password") String password);
}