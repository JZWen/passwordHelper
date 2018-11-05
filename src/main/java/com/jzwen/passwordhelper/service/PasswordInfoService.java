package com.jzwen.passwordhelper.service;

import com.jzwen.passwordhelper.dao.PasswordInfoDao;
import com.jzwen.passwordhelper.pojo.PasswordInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PasswordInfoService {
    @Autowired
    private PasswordInfoDao passwordInfoDao;

    /**
     *  插入信息
     * @return
     */
    public int insertPassword(PasswordInfo passwordInfo){
        return passwordInfoDao.insertPassword(passwordInfo);
    }

    /**
     * 获取密码信息
     * @return
     */
    public ArrayList<PasswordInfo> getPasswordInfo(){
        return passwordInfoDao.getPasswordInfo();
    }

    /**
     * 修改密码信息
     * @param passwordInfo
     * @return
     */
    public int alterPasswordInfo(PasswordInfo passwordInfo){
        return passwordInfoDao.alterPasswordInfo(passwordInfo);
    }

    /**
     * 删除密码信息
     * @param id
     * @return
     */
    public int deletePassword(int id){
        return passwordInfoDao.deletePassword(id);
    }

}
