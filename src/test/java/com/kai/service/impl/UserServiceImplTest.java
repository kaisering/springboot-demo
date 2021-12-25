package com.kai.service.impl;

import com.kai.entity.User;
import com.kai.mapper.sqlite.UserMapper;
import com.kai.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

/**
 * @author Wangkai
 * @description
 * @date 2021/12/22
 */
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Test
    void getUser() {
        Mockito.when(userMapper.getUser("001")).thenReturn(new User().setUserId("001"));
        User user = userService.getUser("001");
        Assertions.assertThat(user).isNotNull().hasFieldOrPropertyWithValue("userId", "001");
    }

    @Test
    void listUser() {
        User user = new User();
        Mockito.when(userMapper.listUser()).thenReturn(Arrays.asList(user));
        List<User> userList = userService.listUser();
        Assertions.assertThat(userList).contains(user);
    }

    @Test
    void addUser() {
        User user = new User();
        Mockito.when(userMapper.addUser(user)).thenReturn(1);
        int count = userService.addUser(user);
        Assertions.assertThat(count).isEqualTo(1);
    }
}