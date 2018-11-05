package com.jzwen.passwordhelper.controller;

import com.jzwen.passwordhelper.Common.EncrUtil;
import com.jzwen.passwordhelper.pojo.PasswordInfo;
import com.jzwen.passwordhelper.service.PasswordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@RestController
public class PasswordController {

    @Autowired
    private PasswordInfoService passwordInfoService;

    private HashMap<Object , Integer> res = new HashMap<>();

    /**
     * 需要插入信息  accountNumber password remark phoneNum
     * @param passwordInfo
     * @return
     */
    @RequestMapping("/insertPassword")
    public HashMap insertPassword(PasswordInfo passwordInfo){
        passwordInfo.setTime(new Date());
        passwordInfo.setPassword(EncrUtil.encrypt(passwordInfo.getPassword()));
        if(passwordInfo!=null
                && passwordInfo.getPassword()!=null
                && passwordInfo.getAccountNumber()!=null
                && passwordInfo.getPhoneNum() !=null
                && passwordInfo.getRemark()!=null
                && passwordInfo.getTime()!=null
        ){
            if(passwordInfoService.insertPassword(passwordInfo) == 1){
                res.put("code" , 1);
            }else {
                res.put("code" , 0);
            }
            return res;
        }else{
            res.put("code", 0);
            return res;
        }
    }

    @RequestMapping("/alterPassword")
    public HashMap alterPassword(PasswordInfo passwordInfo){
        passwordInfo.setPassword(EncrUtil.encrypt(passwordInfo.getPassword()));
        passwordInfo.setTime(new Date());
        if(passwordInfo!=null
                && passwordInfo.getPassword()!=null
                && passwordInfo.getAccountNumber()!=null
                && passwordInfo.getPhoneNum() !=null
                && passwordInfo.getRemark()!=null
                && passwordInfo.getTime()!=null
        ){
            if(passwordInfoService.alterPasswordInfo(passwordInfo)==1){
                res.put("code" , 1);
            }else{
                res.put("code" , 0);
            }
            return res;
        }else{
            res.put("code" , 0);
            return res;
        }
    }

    @RequestMapping("/getPassword")
    public ArrayList<PasswordInfo> getPasssword(){
        /**
         * 获取到的信息需要解密再返回
         */
        ArrayList<PasswordInfo> passwordInfos = passwordInfoService.getPasswordInfo();
        for (int i=0; i<passwordInfos.size(); i++){
            passwordInfos.get(i).setPassword(EncrUtil.decrypt(passwordInfos.get(i).getPassword()));
        }
        return passwordInfos;
    }

    @RequestMapping("/deletePassword")
    public HashMap deletePassword(int id){
        if(passwordInfoService.deletePassword(id)==1){
            res.put("code" , 1);
        }else {
            res.put("code",0);
        }
        return res;
    }
}
