package com.kai.service.impl;

import com.kai.mapper.sqlite.UserMapper;
import com.kai.entity.User;
import com.kai.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Wangkai
 * @description
 * @date 2021/12/18
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String userId) {
        return userMapper.getUser(userId);
    }

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user.setUserId(UUID.randomUUID().toString()));
    }
}
