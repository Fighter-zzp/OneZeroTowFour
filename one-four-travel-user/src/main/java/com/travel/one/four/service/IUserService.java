package com.travel.one.four.service;

import com.travel.one.four.domain.Route;
import com.travel.one.four.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {
    List<User> getList();
  /*  Integer imgSet(User user);*/
  //修改密码
  Integer setPassword(String password);
    //展示收藏
    List<Route> getCollect();
}
