package com.travel.one.four.dao;


import com.travel.one.four.domain.Route;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteDao {
    /**
     * 查询所有旅游路线素材
     * @return
     */
    public List<Route> findAllRoute(Integer routeType);
}
