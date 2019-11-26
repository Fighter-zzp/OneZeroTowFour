package com.travel.one.four.dao;

import com.travel.one.four.domain.TRoute;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface TRouteDao {
    Integer insert(@Param("rname") String rname, @Param("price") Double price, @Param("routeIntroduce") String routeIntroduce, @Param("rimage") String rimage, @Param("cid") Integer cid);
    List<TRoute> getList();
}