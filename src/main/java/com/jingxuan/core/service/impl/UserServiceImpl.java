package com.jingxuan.core.service.impl;

import com.jingxuan.core.dao.UserDao;
import com.jingxuan.core.po.User;
import com.jingxuan.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User findUser(String username, String password) {
        User user = userDao.findUser(username, password);
        return user;
    }
}
