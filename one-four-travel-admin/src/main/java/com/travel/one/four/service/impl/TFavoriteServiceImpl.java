package com.travel.one.four.service.impl;

import com.travel.one.four.domain.TRoute;
import com.travel.one.four.domain.plus.UserFav;
import com.travel.one.four.mapper.TFavoriteMapper;
import com.travel.one.four.mapper.TRouteMapper;
import com.travel.one.four.service.ITFavoriteService;
import com.travel.one.four.utils.ExtendQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TFavoriteServiceImpl implements ITFavoriteService {
    @Autowired
    private TFavoriteMapper tFavoriteMapper;
    @Autowired
    private TRouteMapper tRouteMapper;

    @Override
    public List<TRoute> findByUid(ExtendQueryObject qo) {
        return tRouteMapper.pageFindByUid(qo);
    }

    @Override
    public Integer InfoByUid(Integer uid) {
        return tFavoriteMapper.findUserFav(uid);
    }

    @Override
    public void deleteByRid(Integer rid, Integer uid) {
        tFavoriteMapper.deleteByPrimaryKey(rid, uid);
    }
}
