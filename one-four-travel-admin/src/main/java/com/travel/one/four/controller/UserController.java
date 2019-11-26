package com.travel.one.four.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.one.four.domain.TUser;
import com.travel.one.four.service.ITUserService;
import com.travel.one.four.utils.Msg;
import com.travel.one.four.utils.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ITUserService itUserService;

    @GetMapping("/list")
    public Msg list(@ModelAttribute("qo") QueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        var all = itUserService.queryAll(qo);
        var pageInfo = new PageInfo(all, 3);
        return Msg.sucess().add("pageInfo", pageInfo);
    }

    @PutMapping("/update")
    public void update(TUser user) {
        var i = itUserService.updateOrInsert(user);
    }

    @DeleteMapping("deletes")
    public void deletes(@RequestParam("ids[]") Integer[] ids) {
        itUserService.deleteByIds(ids);
    }

    @DeleteMapping("delete")
    public Msg delete(Integer uid) {
        if (uid == null) return Msg.fail();
        itUserService.deleteByUid(uid);
        return Msg.sucess();
    }
}
