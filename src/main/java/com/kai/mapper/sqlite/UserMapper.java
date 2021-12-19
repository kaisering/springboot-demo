package com.kai.mapper.sqlite;

import com.kai.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Wangkai
 * @Description UserMapper
 * @Date 2021/12/19 18:27
 **/
public interface UserMapper {

    /**
     * @Author Wangkai
     * @Description getUser
     * @Date 2021/12/19 18:27
     * @Param [userId]
     * @return com.kai.entity.User
     **/
    @Select("select * from user where user_id = #{userId}")
    @ResultType(User.class)
    public User getUser(String userId);

    /**
     * @Author Wangkai
     * @Description listUser
     * @Date 2021/12/19 18:27
     * @Param []
     * @return java.util.List<com.kai.entity.User>
     **/
    @Select("select * from user")
    @ResultType(User.class)
    public List<User> listUser();

    /**
     * @Author Wangkai
     * @Description addUser
     * @Date 2021/12/19 18:27
     * @Param [user]
     * @return int
     **/
    @Insert({"insert into user values (#{userId}, #{userName}, #{gender}, #{age})"})
    public int addUser(User user);
}
