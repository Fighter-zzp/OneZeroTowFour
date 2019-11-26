package com.travel.one.four.controller;

import com.travel.one.four.domain.Route;
import com.travel.one.four.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @GetMapping("/findAllRoute/{routeType}")
    public List<Route> findAllRoute(@PathVariable("routeType")Integer routeType){
        List<Route> allRoute = routeService.findAllRoute(routeType);
        for (Route route : allRoute) {
            System.out.println(route);
        }
        return allRoute;
    }
}
