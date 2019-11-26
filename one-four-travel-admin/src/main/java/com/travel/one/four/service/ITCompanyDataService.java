package com.travel.one.four.service;

import com.travel.one.four.domain.TCompanydata;
import com.travel.one.four.domain.TRoute;
import com.travel.one.four.domain.plus.CompanyFav;
import com.travel.one.four.utils.ExtendQueryObject;
import com.travel.one.four.utils.QueryObject;

import java.util.List;

public interface ITCompanyDataService {
    List<CompanyFav> findAll(QueryObject qo);

    void updateOrInsert(TCompanydata company);

    void stop(Integer sid,Integer status);

    CompanyFav findBySid(Integer sid);

    List<TRoute> pageFindBySid(ExtendQueryObject qo);

    void deleteCAndR(Integer uid,Integer rid);

    void ban(Integer rid,Integer status);
}
