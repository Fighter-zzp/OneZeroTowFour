package com.travel.one.four.service;

import com.travel.one.four.domain.Count;
import com.travel.one.four.domain.TUser;
import com.travel.one.four.domain.plus.UserFav;
import com.travel.one.four.utils.QueryObject;

import java.util.List;

public interface ITUserService {
    TUser checkLogin(String username,String password);

    /**
     * 数据计数
     * @return Count
     */
    Count count();

    /**
     * 获取所有用户信息
     */
    List<UserFav> queryAll(QueryObject qo);

    int updateOrInsert(TUser user);

    void deleteByUid(Integer uid);

    void deleteByIds(Integer[] ids);

    UserFav findByUid(Integer uid);
}
