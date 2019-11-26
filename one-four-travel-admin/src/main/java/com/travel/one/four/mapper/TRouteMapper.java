package com.travel.one.four.mapper;

import com.travel.one.four.domain.TRoute;
import com.travel.one.four.utils.ExtendQueryObject;
import com.travel.one.four.utils.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TRouteMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(TRoute record);

    int insertSelective(TRoute record);

    TRoute selectByPrimaryKey(Integer rid);

    List<TRoute> findByCid(@Param("cid") Integer cid);

    int updateByPrimaryKeySelective(TRoute record);

    int updateByPrimaryKey(TRoute record);

    int findCount();

    List<TRoute> pageFindByUid(ExtendQueryObject qo);

    List<TRoute> pageFindBySid(ExtendQueryObject qo);

    List<TRoute> pageFindByCid(ExtendQueryObject qo);

    int updateFlagByRid(@Param("status") Integer status, @Param("rid") Integer rid);

    List<TRoute> findAllInfo(QueryObject qo);

}