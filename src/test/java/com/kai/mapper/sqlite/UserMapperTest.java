package com.kai.mapper.sqlite;

import com.kai.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Wangkai
 * @description
 * @date 2021/12/22
 */
@SpringBootTest
@Transactional
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @BeforeEach
    void addUser() {
        User user = new User().setUserId("test").setUserName("test").setGender("man").setAge(0);
        int count = userMapper.addUser(user);
        Assertions.assertThat(count).isEqualTo(1);
    }

    @Test
    void getUser() {
        User user = userMapper.getUser("test");
        Assertions.assertThat(user)
                .hasFieldOrPropertyWithValue("userId", "test")
                .hasFieldOrPropertyWithValue("userName", "test")
                .hasFieldOrPropertyWithValue("gender", "man")
                .hasFieldOrPropertyWithValue("age", 0);
    }

    @Test
    void listUser() {
        List<User> userList = userMapper.listUser();
        User user = new User().setUserId("test").setUserName("test").setGender("man").setAge(0);
        Assertions.assertThat(userList).contains(user);
    }


}