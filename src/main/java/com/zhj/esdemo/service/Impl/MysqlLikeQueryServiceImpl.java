package com.zhj.esdemo.service.Impl;

import com.zhj.esdemo.mapper.MysqlQueryMapper;
import com.zhj.esdemo.pojo.Content;
import com.zhj.esdemo.service.MysqlLikeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/18 19:16
 */
@Repository
public class MysqlLikeQueryServiceImpl implements MysqlLikeQueryService {

    @Autowired
    private MysqlQueryMapper mysqlLikeQuery;
    @Override
    public List<Content> likeQuery(String key) {
        return mysqlLikeQuery.getContentList(key);
    }
}
