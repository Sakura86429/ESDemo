package com.zhj.esdemo.pojo;

import java.text.SimpleDateFormat;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/3 20:27
 */
public class Word {
//    public static String speechword;
    public String speechword;
//
//    public static void Log(String tag,String log)
//    {
//        if(true)
//            System.out.println(log);
//    }
//
//    public static void Log(String log)
//    {
//        String date=sDateFormat.format(new java.util.Date());
//        if(true){
//            System.out.println("<" + date + ">" + log);
//        }
//    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
    public void setSpeechword(String speechWord) {

        if(true){
            System.out.println("进入word中设置变量：<" + speechWord + ">");
        }
        this.speechword = speechWord;
    }

    public String getSpeechword() {
        return speechword;
    }
}
