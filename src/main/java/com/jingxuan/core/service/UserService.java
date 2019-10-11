package com.jingxuan.core.service;

import com.jingxuan.core.po.User;
import org.springframework.stereotype.Service;

public interface UserService {
    public User findUser(String username,String password);
}
