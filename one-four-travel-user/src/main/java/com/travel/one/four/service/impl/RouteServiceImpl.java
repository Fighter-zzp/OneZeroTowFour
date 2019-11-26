package com.travel.one.four.service.impl;


import com.travel.one.four.dao.RouteDao;
import com.travel.one.four.domain.Route;
import com.travel.one.four.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteDao routeDao;

    @Override
    public List<Route> findAllRoute(Integer routeType) {
        return routeDao.findAllRoute(routeType);
    }
}
