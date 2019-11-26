package com.travel.one.four.service;

import com.travel.one.four.domain.TRoute;
import com.travel.one.four.utils.QueryObject;

import java.util.List;

public interface ITRouteService {
    List<TRoute> allInfo(QueryObject qo);

    void ban(Integer status, Integer rid);
}
