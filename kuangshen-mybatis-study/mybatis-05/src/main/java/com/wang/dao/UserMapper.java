package com.wang.dao;

import com.wang.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @Author: wangyinghao
 * @Date: 2020-06-05 13:34
 **/
public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();
}
