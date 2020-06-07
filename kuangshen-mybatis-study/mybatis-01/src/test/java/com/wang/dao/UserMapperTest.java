package com.wang.dao;

import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {


    @Test
    public void getUserList() {
        //第一步 获取sqlSession对象
        SqlSession sqlSession = null;

        try {
            //第二步 方式一：getMapper
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        // 方式二：
//        诚然，这种方式能够正常工作，对使用旧版本 MyBatis 的用户来说也比较熟悉。
//        但现在有了一种更简洁的方式——使用和指定语句的参数和返回值相匹配的接口（比如 BlogMapper.class），现在你的代码不仅更清晰，
//        更加类型安全，还不用担心可能出错的字符串字面值以及强制类型转换。
//        List<User> userList1 = sqlSession.selectList("com.wang.dao.userMapper.getUserList"); 不推荐使用
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4, "D", "123456");
        mapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUserWithMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 5);
        map.put("name", "E");
        map.put("pwd", "123456");
        mapper.addUserWithMap(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4, "DDD", "123456");
        mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }
}