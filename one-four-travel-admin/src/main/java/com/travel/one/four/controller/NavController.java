package com.travel.one.four.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.one.four.domain.TNav;
import com.travel.one.four.service.ITNavService;
import com.travel.one.four.utils.ExtendQueryObject;
import com.travel.one.four.utils.Msg;
import com.travel.one.four.utils.QueryObject;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nav")
public class NavController {
    @Autowired
    private ITNavService itNavService;

    @GetMapping("list")
    public Msg List() {
        var all = itNavService.findAll();
        return Msg.sucess().add("navList", all);
    }

    @PutMapping("update")
    public Msg update(Integer cid, String cname) {
        itNavService.updateOrInsert(cid, cname);
        return Msg.sucess();
    }

    @PostMapping("add")
    public Msg add(String cname) {
        itNavService.updateOrInsert(0, cname);
        return Msg.sucess();
    }

    @PutMapping("change")
    public Msg change(Integer status, Integer cid) {
        itNavService.banByCid(cid, status);
        return Msg.sucess();
    }

    @GetMapping("/nInfo")
    public Msg nInfo(Integer cid) {
        var nav = itNavService.findByCid(cid);
        return Msg.sucess().add("nInfo", nav);
    }

    @GetMapping("/detailList")
    public Msg dList(@ModelAttribute("qo") ExtendQueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(), 6);
        var tRoutes = itNavService.pageFindByCid(qo);
        var pageInfo = new PageInfo(tRoutes, 3);
        return Msg.sucess().add("pageInfo", pageInfo);
    }

    @DeleteMapping("deleteRoute")
    public Msg deleteRoute(Integer cid, Integer rid) {
        itNavService.deleteCAndR(cid, rid);
        return Msg.sucess();
    }

    @PutMapping("ban")
    public Msg ban(Integer status, Integer rid) {
        itNavService.ban(rid, status);
        return Msg.sucess();
    }
    /*@GetMapping("/allInfo")
    public Msg allInfo(QueryObject qo){
        PageHelper.startPage(qo.getCurrentPage(),6);
        var allInfo = itNavService.findAllInfo(qo);
        var pageInfo = new PageInfo<TNav>(allInfo, 3);
        return Msg.sucess().add("pageInfo", pageInfo);
    }*/
}
