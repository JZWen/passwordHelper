package com.jzwen.passwordhelper.dao;

import com.jzwen.passwordhelper.pojo.PasswordInfo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface PasswordInfoDao {

    /**
     *  插入信息
     * @return
     */
    int insertPassword(PasswordInfo passwordInfo);

    /**
     * 获取密码信息
     * @return
     */
    ArrayList<PasswordInfo> getPasswordInfo();

    /**
     * 修改密码信息
     * @param passwordInfo
     * @return
     */
    int alterPasswordInfo(PasswordInfo passwordInfo);

    /**
     * 删除密码信息
     */
    int deletePassword(int id);
}
