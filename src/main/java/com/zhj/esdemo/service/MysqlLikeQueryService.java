package com.zhj.esdemo.service;

import com.zhj.esdemo.pojo.Content;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MysqlLikeQueryService {
    List<Content> likeQuery(String key);
}
