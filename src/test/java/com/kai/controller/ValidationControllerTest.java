package com.kai.controller;

import com.alibaba.fastjson.JSON;
import com.kai.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Wangkai
 * @description
 * @date 2021/12/25
 */
@Slf4j
@WebMvcTest(ValidationController.class)
class ValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUser() throws Exception {
        UserDTO userDTO = new UserDTO().setUserId("test007").setUserName("Kaiser").setGender("Y").setAge(33);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/validation/user")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSON.toJSONString(userDTO)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("test007"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("Kaiser"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("Y"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(33))
                .andReturn();
        log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}