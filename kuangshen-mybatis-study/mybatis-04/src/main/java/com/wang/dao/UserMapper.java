package com.wang.dao;

import com.wang.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: wangyinghao
 * @Date: 2020-06-04 11:01
 **/
public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    void addUser(User user);

    void addUserWithMap(Map<String, Object> map);

    void updateUser(User user);

    void deleteUser(int id);

    List<User> getUserByLimit(Map<String,Object> map);
}
