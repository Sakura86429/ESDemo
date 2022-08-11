package com.zhj.esdemo.service;

import org.springframework.stereotype.Service;

@Service
public interface RecognizeService {
    String speechrecognize() throws InterruptedException;
}
