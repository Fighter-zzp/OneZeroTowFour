package com.travel.one.four.dao;


import com.travel.one.four.domain.Place;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceDao {
    /**
     * 查询所有地区
     */
    public List<Place> findAllPlace(Integer navid);
}
