package com.travel.one.four.service;


import com.travel.one.four.domain.Route;

import java.util.List;

public interface RouteService {
    /**
     * 查询所有旅游路线素材
     * @return
     */
    public List<Route> findAllRoute(Integer routeType);
}
