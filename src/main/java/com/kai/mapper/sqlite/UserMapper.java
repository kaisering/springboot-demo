package com.kai.mapper.sqlite;

import com.kai.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Wangkai
 * @description
 * @date 2021/12/18
 */
public interface UserMapper {

    @Select("select * from user where user_id = #{userId}")
    @ResultType(User.class)
    public User getUser(String userId);

    @Select("select * from user")
    @ResultType(User.class)
    public List<User> listUser();

    @Insert({"insert into user values (#{userId}, #{userName}, #{gender}, #{age})"})
    public int addUser(User user);
}
