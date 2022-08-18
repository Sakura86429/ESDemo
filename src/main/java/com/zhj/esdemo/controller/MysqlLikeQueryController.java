package com.zhj.esdemo.controller;

import com.zhj.esdemo.pojo.Content;
import com.zhj.esdemo.service.Impl.MysqlLikeQueryServiceImpl;
import com.zhj.esdemo.service.MysqlLikeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/18 19:14
 */
@RestController
public class MysqlLikeQueryController {

    @Autowired
    MysqlLikeQueryServiceImpl mysqlLikeQueryService;

    @GetMapping("/like/{keyword}")
    @ResponseBody
//    public Boolean test(@PathVariable String keyword) throws IOException {
    public List<Content> likeQuery(@PathVariable String keyword) throws IOException {
        System.out.println("模糊查询");
        StringBuffer key = new StringBuffer();
        key.append("%");
        key.append(keyword);
        key.append("%");
        String keyStr = key.toString();
        System.out.println(keyStr);
        List<Content> contents = mysqlLikeQueryService.likeQuery(keyStr);
        System.out.println(contents);
        return contents;
    }
}
