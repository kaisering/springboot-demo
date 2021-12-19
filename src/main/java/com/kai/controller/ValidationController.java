package com.kai.controller;

import com.kai.dto.UserDTO;
import com.kai.validation.group.ValidationGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wangkai
 * @description
 * @date 2021/12/18
 */
@RestController
@RequestMapping("/validation")
public class ValidationController {

    @PostMapping("/user")
    public UserDTO getUser(@RequestBody @Validated({ValidationGroup.FirstGroup.class, ValidationGroup.SecondGroup.class}) UserDTO user) {
        return user;
    }
}
