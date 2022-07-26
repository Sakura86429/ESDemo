package com.zhj.esdemo.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/25 12:49
 */
@Data
@Accessors(chain = true)
public class UserBean {
    private Integer id;
    private String username;
}

