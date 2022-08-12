package com.zhj.esdemo.controller;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/24 20:42
 */

import com.zhj.esdemo.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 前端请求编写
 */
@Controller
public class ContentController {

    @Autowired
    ContentService contentService;

    @GetMapping("/parse/{keyword}")
    @ResponseBody
//    public Boolean test(@PathVariable String keyword) throws IOException {
    public String test(@PathVariable String keyword) throws IOException {
        Boolean parseContext = contentService.parseContext(keyword);
        System.out.println("parseContext = " + parseContext);   // true
        if(parseContext) return "爬取成功";
        else return "没有爬到数据";

//        return parseContext;
    }

    @GetMapping("/search/{keyword}/{pageNO}/{pageSize}")
    @ResponseBody
    public List<Map<String, Object>> search(@PathVariable("keyword") String keyword, @PathVariable("pageNO") int pageNo, @PathVariable int pageSize) throws IOException {
        List<Map<String, Object>> list = contentService.serchPageBuilder(keyword, pageNo, pageSize);
//        System.out.println(list);
        return list;
    }

}
