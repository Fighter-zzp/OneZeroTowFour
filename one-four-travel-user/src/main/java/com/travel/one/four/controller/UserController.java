package com.travel.one.four.controller;

import com.travel.one.four.domain.Route;
import com.travel.one.four.domain.User;
import com.travel.one.four.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    //查询个人信息（要改成根据登录进来的id进行查询）
    @GetMapping(path = "/list")
    public List<User> getList() {
        System.out.println("进入getLista a aa 啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
        List<User> list = userService.getList();
        for (User user : list) {
            System.out.println(user);
        }
        return list;
    }
    @PostMapping (path = "/setPassword")
    public ModelAndView setPassword(String password){
        System.out.println("进入设置密码controller");
        ModelAndView mv = new ModelAndView();
        mv.addObject("psw",password);
        System.out.println(password);
        Integer integer = userService.setPassword(password);
        System.out.println("Iteger="+integer);
        return mv;
    }

    @GetMapping(path = "/getCollect")
    public List<Route> getCollect(){
        System.out.println("进入收藏controller");
        List<Route> list = userService.getCollect();
        for (Route route : list) {
            System.out.println(route);
        }
        return list;
    }
@GetMapping(path="/myfavorite")
    public List<Route> myFavorite(Integer id){
    System.out.println("进入myfavorite啊啊啊啊啊");
        return null;

}

}
