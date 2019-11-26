package com.travel.one.four.service;


import com.travel.one.four.domain.RouteImg;

import java.util.List;

public interface RouteImgService {

    /**
     * 查询首页轮播图
     * @return
     */
    public List<RouteImg> findAllRouteImg();
}
