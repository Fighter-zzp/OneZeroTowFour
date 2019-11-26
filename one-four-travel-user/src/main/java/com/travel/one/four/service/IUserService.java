package com.travel.one.four.service;

import com.travel.one.four.domain.Route;
import com.travel.one.four.domain.User;

import java.util.List;


public interface IUserService {

    /**
     * 查询用户是否存在
     * @param username
     * @return
     */
    public User findByName(String username);

    /**
     * 验证用户登录
     * @param username
     * @param password
     * @return
     */
    public User login(String username,String password);



    /**
     * 传递用户对象注册用户
     * @param user
     */
    public Integer registerUser(User user);

    List<User> getList();
    /*  Integer imgSet(User user);*/
    //修改密码
    Integer setPassword(String password);
    //展示收藏
    List<Route> getCollect();

    //点击图片后把rid（应该还有用户id）保存到favorite表中
    Integer saveTwoId(Integer rid,Integer uid);
    List<Route>  myfavorite(Integer uid);
}
