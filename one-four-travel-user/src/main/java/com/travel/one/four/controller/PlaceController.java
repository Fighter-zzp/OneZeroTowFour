package com.travel.one.four.controller;


import com.travel.one.four.domain.Place;
import com.travel.one.four.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping("/findAllPlace/{navId}")
    public List<Place> findAllPlace(@PathVariable("navId")Integer navId){
        List<Place> allPlace = placeService.findAllPlace(navId);
        return allPlace;
    }
}
