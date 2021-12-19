package com.kai.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: WangKai
 * @Date: 2021/12/18 19:35:36
 * @Version 1.0.0
 * @Description: DTO
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private final static long serialVersionUID = -1L;

    private String userId;

    private String userName;

    private String gender;

    private Integer age;

}
