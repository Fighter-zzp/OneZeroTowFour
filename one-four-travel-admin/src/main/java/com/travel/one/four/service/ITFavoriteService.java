package com.travel.one.four.service;

import com.travel.one.four.domain.TRoute;
import com.travel.one.four.domain.plus.UserFav;
import com.travel.one.four.utils.ExtendQueryObject;

import java.util.List;

public interface ITFavoriteService {
    List<TRoute> findByUid(ExtendQueryObject qo);

    /**
     * 收藏用户的个人信息
     */
    Integer InfoByUid(Integer uid);

    void deleteByRid(Integer rid, Integer uid);
}
