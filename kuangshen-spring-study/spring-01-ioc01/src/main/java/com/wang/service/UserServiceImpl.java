package com.wang.service;

import com.wang.dao.UserDao;
import com.wang.dao.UserDaoImpl;

/**
 * @Description:
 * @Author: wangyinghao
 * @Date: 2020-06-07 11:20
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    // 利用set进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
