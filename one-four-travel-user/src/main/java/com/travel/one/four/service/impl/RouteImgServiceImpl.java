package com.travel.one.four.service.impl;


import com.travel.one.four.dao.RouteImgDao;
import com.travel.one.four.domain.RouteImg;
import com.travel.one.four.service.RouteImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteImgServiceImpl implements RouteImgService {
    @Autowired
    private RouteImgDao routeImgDao;

    @Override
    public List<RouteImg> findAllRouteImg() {
        return routeImgDao.findAllRouteImg();
    }
}
