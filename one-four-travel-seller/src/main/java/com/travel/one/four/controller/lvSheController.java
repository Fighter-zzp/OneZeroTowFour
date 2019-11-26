package com.travel.one.four.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.one.four.domain.Company;
import com.travel.one.four.domain.Msg;
import com.travel.one.four.domain.TRoute;
import com.travel.one.four.service.TRoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/lvshe")
public class lvSheController {
    @Autowired
    private TRoutService tRoutService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Msg addLvShe(TRoute route, MultipartFile file, HttpServletRequest request) throws IOException {
        //获取上传文件的文件名和后缀名
        String fn = file.getOriginalFilename();
        //创建需要保存的的文件对象  ("/static/images/8888/"), fn)
        var desFile = new File(request.getSession().getServletContext().getRealPath("/static/img/product/small/"), fn);
        file.transferTo(desFile);
        route.setRimage("img/product/small/88888-" + desFile.getName());
        var login = (Company) request.getSession().getAttribute("login");
        route.setSid(login.getSid()
        );
        if (tRoutService.save(route)) {
            return Msg.sucess();
        } else {
            return Msg.fail();
        }


    }

    @RequestMapping(value = "navs",method = RequestMethod.GET)
    @ResponseBody
    public Msg navList(){
        return Msg.sucess().add("navs",tRoutService.getNav());
    }


    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Msg routeList(Integer currentPage, HttpSession session){
        PageHelper.startPage(currentPage,6);
        var login = (Company)session.getAttribute("login");
        var tRoutes = tRoutService.pageList(login.getSid());
        var pageInfo = new PageInfo<TRoute>(tRoutes, 5);
        return Msg.sucess().add("pageInfo",pageInfo);
    }
}
