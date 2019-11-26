package com.travel.one.four.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.one.four.domain.TCompanydata;
import com.travel.one.four.domain.TRoute;
import com.travel.one.four.service.ITCompanyDataService;
import com.travel.one.four.utils.ExtendQueryObject;
import com.travel.one.four.utils.Msg;
import com.travel.one.four.utils.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyDataController {
    @Autowired
    private ITCompanyDataService itCompanyDataService;

    @GetMapping("/list")
    public Msg list(@ModelAttribute("qo")QueryObject qo){
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        var all = itCompanyDataService.findAll(qo);
        var pageInfo = new PageInfo(all, 3);
        return Msg.sucess().add("pageInfo",pageInfo);
    }

    @PutMapping("/update")
    public void update(TCompanydata company) {
        itCompanyDataService.updateOrInsert(company);
    }

    @PutMapping("/change")
    public Msg stop(Integer sid,Integer status){
        if (sid>0)
            itCompanyDataService.stop(sid,status);
        return Msg.sucess();
    }

    @GetMapping("/detailList")
    public Msg cInfo(@ModelAttribute("qo")ExtendQueryObject qo){
        PageHelper.startPage(qo.getCurrentPage(),6);
        var tRoutes = itCompanyDataService.pageFindBySid(qo);
        var pageInfo = new PageInfo(tRoutes, 3);
        return Msg.sucess().add("pageInfo",pageInfo);
    }

    @GetMapping("cInfo")
    public Msg cInfo(Integer sid){
        return Msg.sucess().add("cInfo",itCompanyDataService.findBySid(sid));
    }

    @DeleteMapping("deleteRoute")
    public Msg deleteRoute(Integer sid,Integer rid){
        itCompanyDataService.deleteCAndR(sid,rid);
        return Msg.sucess();
    }

    @PutMapping("ban")
    public Msg ban(Integer status,Integer rid){
        itCompanyDataService.ban(rid,status);
        return Msg.sucess();
    }


}
