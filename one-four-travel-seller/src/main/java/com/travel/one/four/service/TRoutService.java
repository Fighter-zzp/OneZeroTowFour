package com.travel.one.four.service;

import com.travel.one.four.domain.TNav;
import com.travel.one.four.domain.TRoute;

import java.util.List;

public interface TRoutService {
    List<TNav> getNav();

    boolean save(TRoute route);

    List<TRoute> pageList(Integer sid);

}
