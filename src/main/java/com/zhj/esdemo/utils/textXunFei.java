package com.zhj.esdemo.utils;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/3 20:06
 */

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/3 15:19
 */

import com.iflytek.cloud.speech.RecognizerListener;
import com.iflytek.cloud.speech.RecognizerResult;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechRecognizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.zhj.esdemo.iflytek.util.DebugLog;
import com.zhj.esdemo.iflytek.util.JsonParser;
import com.zhj.esdemo.iflytek.util.Version;
import com.zhj.esdemo.pojo.Word;

public class textXunFei extends Thread {

    // 语音听写对象
    SpeechRecognizer speechRecognize;

    // 语音识别结果和防回调flag
    Word speechword;
    Boolean flag = true;

    public textXunFei() {
        // 初始化听写对象
        speechRecognize = SpeechRecognizer.createRecognizer();
        System.out.println("speechRecognize.isListening() is " + speechRecognize.isListening());
    }


    public textXunFei(Word word) {
        this.speechword = word;
        // 初始化听写对象
        speechRecognize = SpeechRecognizer.createRecognizer();
    }

    public void run() {
        if (!speechRecognize.isListening()) {
            System.out.println("run()函数执行startListening");
            speechRecognize.startListening(mRecoListener);
        }
        else {
            speechRecognize.stopListening();
            System.out.println("stopListening");
        }
    }

    //开始监听并向讯飞服务器发送语音
    public int startListen() {
        if (!speechRecognize.isListening()) {
            System.out.println("startListen()方法执行startListening");
            speechRecognize.startListening(mRecoListener);
        }
        else {
            speechRecognize.stopListening();
            System.out.println("stopListening");
        }
        return 0;
    }

//    public void stopListen() {
//        speechRecognize.stopListening();;
//    }


    /**
     * 监听器
     */
    private RecognizerListener mRecoListener = new RecognizerListener(){

        //获取结果
        public void onResult(RecognizerResult results, boolean isLast){
            //用json来获取结果
            String text = results.getResultString();
            JsonParser json = new JsonParser();
            String newTest = json.parseIatResult(text);
            if (flag) {
                speechword.setSpeechword(newTest);
                flag = false;
            }
            System.out.println("newTest " + newTest);
//            if (isLast) {
//                System.out.println("识别结束");
//            }
        }

        //会话发生错误回调接口
        public void onError(SpeechError error) {
            DebugLog.Log("onError enter");

            if (null != error) {

                DebugLog.Log("onError Code：" + error.getErrorCode());

            }
        }
        //开始录音
        public void onBeginOfSpeech() {
            DebugLog.Log("开始说话");
        }
        //音量值0~30
        public void onVolumeChanged(int volume){}
        //结束录音
        public void onEndOfSpeech() {}
        //扩展用接口
        public void onEvent(int eventType,int arg1,int arg2,String msg) {}
    };

    public static void main(String[] args) {
        //初始化听写对象
        textXunFei t = new textXunFei();
        StringBuffer param = new StringBuffer();

        param = new StringBuffer();
        param.append( "appid=" + Version.getAppid() );
        SpeechUtility.createUtility(param.toString() );
//        t.startListen();
        t.start();

    }
}

