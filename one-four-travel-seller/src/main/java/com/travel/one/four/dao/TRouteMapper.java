package com.travel.one.four.dao;

import com.travel.one.four.domain.TRoute;

import java.util.List;

public interface TRouteMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(TRoute record);

    int insertSelective(TRoute record);

    TRoute selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(TRoute record);

    int updateByPrimaryKey(TRoute record);

    List<TRoute> findAllBySid(Integer sid);
}