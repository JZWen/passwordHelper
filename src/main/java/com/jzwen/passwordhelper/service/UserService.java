package com.jzwen.passwordhelper.service;

import com.jzwen.passwordhelper.dao.UserDao;
import com.jzwen.passwordhelper.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int insertUser(User user){
        return userDao.insertUser(user);
    }

    //查询user 添加user
    public User getUser(User user){
        return userDao.getUser(user);
    }

    //设置默认密码
    public int updateDefPassword(User user){
        return userDao.updateDefPassword(user);
    }

    //自定义设置密码
    public int alterInfo(User user){
        return userDao.alterInfo(user);
    }

    public ArrayList<User> getAllUser(){
        return userDao.getAllUser();
    }
}
