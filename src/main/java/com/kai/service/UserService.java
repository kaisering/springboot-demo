package com.kai.service;

import com.kai.entity.User;

import java.util.List;

/**
 * @Author Wangkai
 * @Description UserService
 * @Date 2021/12/19 17:54
 **/
public interface UserService {

    /**
     * @Author Wangkai
     * @Description getUser
     * @Date 2021/12/19 17:56
     * @Param [userId]
     * @return com.kai.entity.User
     **/
    User getUser(String userId);

    /**
     * @Author Wangkai
     * @Description listUser
     * @Date 2021/12/19 17:56
     * @Param []
     * @return java.util.List<com.kai.entity.User>
     **/
    List<User> listUser();

    /**
     * @Author Wangkai
     * @Description addUser
     * @Date 2021/12/19 17:57
     * @Param [user]
     * @return int
     **/
    int addUser(User user);
}
