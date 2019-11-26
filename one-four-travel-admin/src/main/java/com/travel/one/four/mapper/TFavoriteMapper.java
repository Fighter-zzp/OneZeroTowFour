package com.travel.one.four.mapper;

import com.travel.one.four.domain.TFavorite;
import com.travel.one.four.domain.TRoute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TFavoriteMapper {
    int deleteByPrimaryKey(@Param("rid") Integer rid, @Param("uid") Integer uid);

    int insert(TFavorite record);

    int insertSelective(TFavorite record);

    TFavorite selectByPrimaryKey(@Param("rid") Integer rid, @Param("uid") Integer uid);

    int updateByPrimaryKeySelective(TFavorite record);

    int updateByPrimaryKey(TFavorite record);

    int findCount();

    Integer findUserFav(Integer uid);

}