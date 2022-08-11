package com.zhj.esdemo.controller;

import com.zhj.esdemo.service.ContentService;
import com.zhj.esdemo.service.Impl.RecognizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/3 19:55
 */

/**
 前端请求编写
 */
@Controller
public class SpeechRecoginzeController {

    @Autowired
    RecognizeServiceImpl recognizeService;

    @Autowired
    ContentService contentService;

    @RequestMapping("/speechSearch")
    @ResponseBody
    public List<Object> speech() throws IOException, InterruptedException {

        // 封装结果集
        List<Object> resultList = new ArrayList<>();

        // 语音转文字
        System.out.println("speech test");
        String speechword = recognizeService.speechrecognize();
        System.out.println("speechword = " + speechword);
//        speechword = "苹果";
//        System.out.println("speechword = " + speechword);
        if (speechword == null || speechword == "") speechword = "很抱歉没有识别到，请再说一遍";



        // 搜索
        List<Map<String, Object>> list = contentService.serchPageBuilder(speechword, 0, 20);


        resultList.add(speechword);
        resultList.add(list);
        return resultList;

//        // 未识别
//        if (speechword == null) {
//            speechword = "很抱歉没有识别到，请再说一遍";
//            Map<String, Object> map = new HashMap<String, Object>() {
//                {
//                    put("img", "0");
//                    put("fragment", "0");
//                    put("price", "0");
//                }
//            };
//            List<Map<String, Object>> list0 = new ArrayList<>();
//            list0.add(map);
//            list = list0;
//        }


    }
}
