package com.travel.one.four.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.one.four.domain.TRoute;
import com.travel.one.four.service.ITRouteService;
import com.travel.one.four.utils.Msg;
import com.travel.one.four.utils.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private ITRouteService itRouteService;

    @GetMapping("/allInfo")
    public Msg allInfo(QueryObject qo){
        PageHelper.startPage(qo.getCurrentPage(),6);
        var allInfo = itRouteService.allInfo(qo);
        var pageInfo = new PageInfo<TRoute>(allInfo,3);
        return Msg.sucess().add("pageInfo",pageInfo);
    }

    @PutMapping("ban")
    public Msg ban(Integer status,Integer rid){
        itRouteService.ban(status, rid);
        return Msg.sucess();
    }
}
