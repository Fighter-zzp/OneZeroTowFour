package com.travel.one.four.service;

import com.travel.one.four.domain.TNav;
import com.travel.one.four.domain.TRoute;
import com.travel.one.four.domain.plus.NavsFav;
import com.travel.one.four.utils.ExtendQueryObject;
import com.travel.one.four.utils.QueryObject;

import java.util.List;

public interface ITNavService {
    List<NavsFav> findAll();

    void updateOrInsert(Integer cid, String cname);

    void banByCid(Integer cid, Integer status);

    TNav findByCid(Integer cid);

    List<TRoute> pageFindByCid(ExtendQueryObject qo);

    void deleteCAndR(Integer cid, Integer rid);

    void ban(Integer rid, Integer status);

    List<TNav> findAllInfo(QueryObject qo);
}
