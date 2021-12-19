package com.kai.dto;

import com.kai.validation.group.ValidationGroup;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangkai
 * @description
 * @date 2021/12/18
 */
@Data
public class UserDTO {
    @NotBlank(message = "userId can not be null", groups = ValidationGroup.FirstGroup.class)
    private String userId;
    @NotBlank(message = "userName can not be null", groups = ValidationGroup.FirstGroup.class)
    private String userName;
    @Pattern(regexp = "[Y,N]", message = "must be Y or N", groups = ValidationGroup.SecondGroup.class)
    private String gender;
    @NotNull(message = "age can not be null", groups = ValidationGroup.ThirdGroup.class)
    private Integer age;
    //    @Size(min = 0, message = "list can not be empty")
    @Valid
    private List<UserDTO> list = new ArrayList();
}
