package com.travel.one.four.dao;

import com.travel.one.four.domain.TNav;

import java.util.List;

public interface TNavMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(TNav record);

    int insertSelective(TNav record);

    TNav selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(TNav record);

    int updateByPrimaryKey(TNav record);

    List<TNav> findAll();
}