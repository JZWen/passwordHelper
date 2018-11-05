package com.jzwen.passwordhelper.controller;

import com.jzwen.passwordhelper.Common.EncrUtil;
import com.jzwen.passwordhelper.pojo.User;
import com.jzwen.passwordhelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    public User insertUser(User user ){
        if(user.getUserName()!=null && user.getPhoneNum() != null && user.getPassword() != null){
            String pwd = EncrUtil.encrypt(user.getPassword());
            System.out.println(pwd);
            if(pwd != null){
                user.setPassword(pwd);
                userService.insertUser(user);
                return user;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    //用于登录使用
    @RequestMapping("/getUser")
    public HashMap getUser(User user , HttpServletRequest request){
        HashMap<Object , Object> res = new HashMap<>();
        if(user.getPassword() != null && user.getPhoneNum() !=null){
            String pwd = EncrUtil.encrypt(user.getPassword());
            user.setPassword(pwd);
            if(userService.getUser(user)== null){
                res.put("code",0);
            }else {
                //设置session
                HttpSession session = request.getSession();
                session.setAttribute("user" , user.getPhoneNum());
                res.put("code",1);
            }
            return res;
        }else {
            res.put("code",0);
            return res;
        }
    }

    /**
     * 电话号码 密码 用户名 都要有
     *
     * @return
     */
    //除了电话号码 其他的都可以修改
    @RequestMapping("/alterInfo")
    public HashMap<Object, Integer> alterInfo(User user){
        /**
         * 我这还是直接修改密码吧 不用再去验证了
         */
       // 首先要去查询一遍的您的密码是否正确
//         User user = new User();
//        user.setPassword(data.get("password"));
//        user.setPhoneNum(data.get("phoneNum"));
//        user.setPassword(EncrUtil.encrypt(user.getPassword()));
//
//        user.setPassword(data.get("password"));
//        user.setPhoneNum(data.get("phoneNum"));
//        user.setUserName(data.get("password"));
        System.out.println(user.toString());
        user.setPassword(EncrUtil.encrypt(user.getPassword()));
        HashMap<Object , Integer> res = new HashMap<>();
        if(user.getPhoneNum() != null && user.getPassword() !=null && user.getUserName() !=null){
            if(userService.alterInfo(user) == 1){
                res.put("code" ,1);
            }else {
                res.put("code",0);
            }
            return res;
        }else {
            res.put("code",0);
            return res;
        }
    }
}
