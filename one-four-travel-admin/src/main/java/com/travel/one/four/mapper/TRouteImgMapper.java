package com.travel.one.four.mapper;

import com.travel.one.four.domain.TRouteImg;

import java.util.List;

public interface TRouteImgMapper {
    int deleteByPrimaryKey(Integer rgid);

    int insert(TRouteImg record);

    int insertSelective(TRouteImg record);

    TRouteImg selectByPrimaryKey(Integer rgid);

    int updateByPrimaryKeySelective(TRouteImg record);

    int updateByPrimaryKey(TRouteImg record);

    List<TRouteImg> findByRid(Integer rid);
}