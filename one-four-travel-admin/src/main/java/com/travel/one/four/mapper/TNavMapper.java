package com.travel.one.four.mapper;

import com.travel.one.four.domain.TNav;import com.travel.one.four.domain.plus.NavsFav;import com.travel.one.four.utils.QueryObject;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface TNavMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(TNav record);

    int insertSelective(TNav record);

    TNav selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(TNav record);

    int updateByPrimaryKey(TNav record);

    int findCount();

    List<NavsFav> findAll();

    int updateByCid(@Param("cid") Integer cid, @Param("status") Integer status);

    int deleteByCidAndRid(@Param("cid") Integer cid, @Param("rid") Integer rid);

    List<TNav> findAllInfo(QueryObject qo);
}