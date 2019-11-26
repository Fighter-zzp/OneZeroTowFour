package com.travel.one.four.service.impl;


import com.travel.one.four.dao.PlaceDao;
import com.travel.one.four.domain.Place;
import com.travel.one.four.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceDao placeDao;

    @Override
    public List<Place> findAllPlace(Integer navid) {
        return placeDao.findAllPlace(navid);
    }
}
