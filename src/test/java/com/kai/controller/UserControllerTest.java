package com.kai.controller;

import com.alibaba.fastjson.JSON;
import com.kai.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Wangkai
 * @description
 * @date 2021/12/20
 */
@Slf4j
class UserControllerTest extends BaseTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    void getUser() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/user/{userId}", "001")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("kai"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("男"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(33))
                .andReturn();
        log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void getUserById() throws Exception {
        User user = new User().setUserId("001");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/user/get")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSON.toJSONString(user)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("kai"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("男"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(33))
                .andReturn();
        log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void listUser() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/user/")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void addUser() throws Exception {
        User user = new User().setUserName("Kaiser").setGender("man").setAge(33);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/user")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSON.toJSONString(user)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1"))
                .andReturn();
        log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}