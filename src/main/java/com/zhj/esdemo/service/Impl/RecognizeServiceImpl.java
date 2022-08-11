package com.zhj.esdemo.service.Impl;

import com.iflytek.cloud.speech.SpeechUtility;
import com.zhj.esdemo.iflytek.util.Version;
import com.zhj.esdemo.pojo.Word;
import com.zhj.esdemo.service.RecognizeService;
import com.zhj.esdemo.utils.textXunFei;
import org.springframework.stereotype.Repository;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/3 20:01
 */
@Repository
public class RecognizeServiceImpl implements RecognizeService {
    @Override
    public String speechrecognize() throws InterruptedException {

        Word word = new Word();
        //初始化听写对象
        textXunFei t = new textXunFei(word);
        StringBuffer param = new StringBuffer();
        param.append( "appid=" + Version.getAppid() );
        SpeechUtility.createUtility(param.toString() );
//        t.startListen();
        t.start();
        Thread.sleep(4000);
        return word.getSpeechword();
    }
}
