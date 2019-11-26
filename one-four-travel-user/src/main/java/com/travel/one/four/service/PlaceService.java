package com.travel.one.four.service;



import com.travel.one.four.domain.Place;

import java.util.List;

public interface PlaceService {

    /**
     * 查询所有地区
     */
    public List<Place> findAllPlace(Integer navid);
}
