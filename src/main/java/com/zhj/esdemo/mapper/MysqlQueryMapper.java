package com.zhj.esdemo.mapper;

import com.zhj.esdemo.pojo.Content;
import com.zhj.esdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MysqlQueryMapper {

    // 查询数据
    @Select("select * from my_jd_goods where title like #{title}")
//    @Select("select * from my_jd_goods")
    List<Content> getContentList(String title);
}
