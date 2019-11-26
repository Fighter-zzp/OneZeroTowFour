package com.travel.one.four.service.Impl;

import com.travel.one.four.dao.TNavMapper;
import com.travel.one.four.dao.TRouteMapper;
import com.travel.one.four.domain.TNav;
import com.travel.one.four.domain.TRoute;
import com.travel.one.four.service.TRoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TRoutServiceImpl implements TRoutService {
    @Autowired
    private TRouteMapper tRouteMapper;
    @Autowired
    private TNavMapper tNavMapper;

    @Override
    public List<TNav> getNav(){
        return tNavMapper.findAll();
    }


    @Override
    public boolean save(TRoute route) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        var format = sdf.format(new Date());
        route.setRdate(format);
        return tRouteMapper.insertSelective(route)>0;
    }

    @Override
    public List<TRoute> pageList(Integer sid) {
        return tRouteMapper.findAllBySid(sid);
    }
}
