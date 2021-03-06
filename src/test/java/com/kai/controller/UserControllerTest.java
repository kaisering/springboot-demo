package com.kai.controller;

import com.alibaba.fastjson.JSON;
import com.kai.entity.User;
import com.kai.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Wangkai
 * @description
 * @date 2021/12/20
 */
@Slf4j
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getUser() throws Exception {
        Mockito.when(userService.getUser("001")).thenReturn(new User().setUserId("001"));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/user/{userId}", "001")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("001"))
                .andReturn();
        log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void getUserById() throws Exception {
        User user = new User().setUserId("001");
        Mockito.when(userService.getUser("001")).thenReturn(user);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/user/get")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSON.toJSONString(user)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("001"))
                .andReturn();
        log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void listUser() throws Exception {
        Mockito.when(userService.listUser()).thenReturn(Arrays.asList(new User().setUserId("001")));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/user/")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].userId").value("001"))
                .andReturn();
        log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void addUser() throws Exception {
        User user = new User().setUserName("Kaiser").setGender("man").setAge(33);
        Mockito.when(userService.addUser(user)).thenReturn(1);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/user")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSON.toJSONString(user)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1"))
                .andReturn();
        log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

}