package com.jzwen.passwordhelper.dao;

import com.jzwen.passwordhelper.pojo.User;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;

@Repository
public interface UserDao {

    int insertUser(User user);

    //查询user 添加user
    User getUser(User user);

    //设置默认密码
    int updateDefPassword(User user);

    //自定义设置密码
    int alterInfo(User user);

    ArrayList<User> getAllUser();
}
