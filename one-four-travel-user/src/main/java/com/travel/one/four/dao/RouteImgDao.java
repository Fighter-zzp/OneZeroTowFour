package com.travel.one.four.dao;


import com.travel.one.four.domain.RouteImg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteImgDao {

    /**
     * 查询首页轮播图
     * @return
     */
    public List<RouteImg> findAllRouteImg();

}
