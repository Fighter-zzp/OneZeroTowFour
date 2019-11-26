package com.travel.one.four.service.impl;

import com.travel.one.four.domain.Count;
import com.travel.one.four.domain.TFavorite;
import com.travel.one.four.domain.TUser;
import com.travel.one.four.domain.plus.UserFav;
import com.travel.one.four.mapper.*;
import com.travel.one.four.service.ITUserService;
import com.travel.one.four.utils.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserServiceImpl implements ITUserService {
    @Autowired
    private TUserMapper tUserMapper;
    @Autowired
    private TFavoriteMapper tFavoriteMapper;

    @Override
    public TUser checkLogin(String username, String password) {
        return tUserMapper.checkLogin(username, password);
    }

    @Override
    public Count count() {
        var list = tUserMapper.findCount();
        return new Count(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
    }

    @Override
    public List<UserFav> queryAll(QueryObject qo) {
        return tUserMapper.findAll(qo);
    }

    @Override
    public int updateOrInsert(TUser user) {
        var uid=0;
        if (user.getUid()>0){
            uid = tUserMapper.updateByPrimaryKeySelective(user);
        }else {
            uid = tUserMapper.insertSelective(user);
        }
        return uid;
    }

    @Override
    public void deleteByUid(Integer uid) {
        if (uid>0)
            tUserMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        if (ids.length>0)
            tUserMapper.deleteByIds(ids);
    }

    @Override
    public UserFav findByUid(Integer uid) {
        return tUserMapper.findByUid(uid);
    }
}
