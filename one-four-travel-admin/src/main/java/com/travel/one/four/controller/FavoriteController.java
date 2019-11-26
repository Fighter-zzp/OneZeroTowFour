package com.travel.one.four.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.one.four.domain.TFavorite;
import com.travel.one.four.domain.TRoute;
import com.travel.one.four.domain.TUser;
import com.travel.one.four.domain.plus.UserFav;
import com.travel.one.four.service.ITFavoriteService;
import com.travel.one.four.service.ITUserService;
import com.travel.one.four.utils.ExtendQueryObject;
import com.travel.one.four.utils.Msg;
import com.travel.one.four.utils.QueryObject;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    private ITFavoriteService itFavoriteService;
    @Autowired
    private ITUserService itUserService;

    @GetMapping("/routes")
    public Msg routes(@ModelAttribute("qo") ExtendQueryObject qo){
        PageHelper.startPage(qo.getCurrentPage(),6);
        var allByUid = itFavoriteService.findByUid(qo);
        var pageInfo = new PageInfo(allByUid, 3);
        return Msg.sucess().add("pageInfo",pageInfo);
    }

    @GetMapping("/userInfo")
    public Msg userInfo(Integer uid){
        var user = itUserService.findByUid(uid);
        return Msg.sucess().add("user",user);
    }

    /**
     * a标签删除，使用get方便运行，这里应该是delete方式
     */
    @DeleteMapping("/delete")
    public Msg delete(Integer rid,Integer uid){
        if (rid<=0&&uid<=0) return Msg.fail();
         itFavoriteService.deleteByRid(rid,uid);
         return Msg.sucess();
    }

}
