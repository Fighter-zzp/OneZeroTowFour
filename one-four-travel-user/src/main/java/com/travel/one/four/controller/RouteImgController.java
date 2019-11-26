package com.travel.one.four.controller;


import com.travel.one.four.domain.RouteImg;
import com.travel.one.four.service.RouteImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/routeImg")
public class RouteImgController {

    @Autowired
    private RouteImgService routeImgService;


    @GetMapping("/findAllRouteImg")
    public List<RouteImg> findAllRouteImg(){
        List<RouteImg> allRouteImg1 = routeImgService.findAllRouteImg();
        for (RouteImg routeImg : allRouteImg1) {
            System.out.println(routeImg);
        }
        return allRouteImg1;
    }
}
