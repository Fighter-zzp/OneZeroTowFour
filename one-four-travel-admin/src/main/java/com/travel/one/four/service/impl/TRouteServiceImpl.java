package com.travel.one.four.service.impl;

import com.travel.one.four.domain.TRoute;
import com.travel.one.four.mapper.TRouteMapper;
import com.travel.one.four.service.ITRouteService;
import com.travel.one.four.utils.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TRouteServiceImpl implements ITRouteService {
    @Autowired
    TRouteMapper tRouteMapper;

    @Override
    public List<TRoute> allInfo(QueryObject qo) {
        return tRouteMapper.findAllInfo(qo);
    }

    @Override
    public void ban(Integer status, Integer rid) {
        tRouteMapper.updateFlagByRid(status, rid);
    }
}
