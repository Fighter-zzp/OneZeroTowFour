package com.travel.one.four.service.impl;

import com.travel.one.four.dao.IUserDao;
import com.travel.one.four.domain.Route;
import com.travel.one.four.domain.User;
import com.travel.one.four.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public User login(String username,String password) {
        return userDao.login(username,password);
    }

    @Override
    public Integer registerUser(User user) {
        return userDao.registerUser(user);
    }




    @Override
    public List<User> getList() {
        return userDao.getList();
    }

    @Override
    public Integer setPassword(String password) {
        return userDao.setPassword(password);
    }

    @Override
    public List<Route> getCollect() {
        return userDao.getCollect();
    }

    @Override
    public Integer saveTwoId(Integer rid, Integer uid) {
        return userDao.saveTwoId(rid,uid);
    }

    @Override
    public List<Route> myfavorite(Integer uid) {
        return userDao.myfavorite(uid);
    }

}
