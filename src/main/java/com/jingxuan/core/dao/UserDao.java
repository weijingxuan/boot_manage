package com.jingxuan.core.dao;

import com.jingxuan.core.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    /**
     * 通过账户和密码查询用户
     */
    public User findUser(@Param("usercode")String usercode,@Param("password")String password);
}
