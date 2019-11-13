package com.travel.one.four.dao;

import com.travel.one.four.domain.Route;
import com.travel.one.four.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userDao")
public interface IUserDao {

    //根据登录用户的id查询自己的个人信息
    List<User> getList();

    /*  Integer imgSet(User user);*/
    //修改密码
    Integer setPassword(String password);

    //展示收藏(测试用的方法)
    List<Route> getCollect();

    //查询总条数（分页用）
    int count();



    /**
     * 分页查询
     *
     * @param
     * @return
     */
    List<Route> page(Map<String, Object> params);
}
