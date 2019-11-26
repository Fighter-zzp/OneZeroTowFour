package com.travel.one.four.controller;

import com.travel.one.four.domain.Route;
import com.travel.one.four.domain.User;
import com.travel.one.four.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    //处理用户名是否存在
    @GetMapping("/findByName")
    public Map<String, Object> findByName(String username) {
        User byName = userService.findByName(username);
        Map<String, Object> map = new HashMap<String, Object>();

        if (byName != null) {
            map.put("msg", "用户名已存在");
        } else {
            map.put("msg", "用户名可用");
        }
        return map;
    }
 /*   public String test(HttpServletRequest request,Model model){
        request.getSession().setAttribute("xxx", "xxxx");*/


    //处理登录请求
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam(value = "username",required = false) String username,
                                     @RequestParam(value = "password",required = false) String password,
                                     HttpServletRequest req, Model model) {
        User user = userService.login(username, password);
        Map<String, Object> map = new HashMap<String, Object>();
        if (user != null) {
            req.getSession().setAttribute("username",user.getUsername());
            map.put("flag",true);
            map.put("msg", "登录成功");
        }else{
            map.put("flag",false);
            map.put("msg", "密码输入有误！");
        }
        return map;
    }


    //判断用户是否登录成功
    @GetMapping("/isLogin")
    public  Map<String, Object> isLogin(HttpSession session){
        Object username = session.getAttribute("username");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username",username);
        return map;
    }


    //用户注册
    @PostMapping("/registerUser")
    public Map<String, Object> registerUser(@RequestParam(value = "user",required = false) User user) {
        Integer integer = userService.registerUser(user);
        Map<String, Object> map = new HashMap<String, Object>();
        if(integer>0){
            map.put("flag",true);
            map.put("msg","注册成功");
        }else {
            map.put("flag",false);
        }
        return map;
    }



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

    @PostMapping(path = "/setPassword")
    public ModelAndView setPassword(String password) {
        System.out.println("进入设置密码controller");
        ModelAndView mv = new ModelAndView();
        mv.addObject("psw", password);
        System.out.println(password);
        Integer integer = userService.setPassword(password);
        System.out.println("Iteger=" + integer);
        return mv;
    }

    @GetMapping("/getCollect")
    public List<Route> getCollect() {
        return userService.getCollect();
    }

    @PostMapping("/saveId")
    public Integer saveId(int rid) {

        System.out.println(rid);
        Integer integer = userService.saveTwoId(rid, 8);
        System.out.println("fsdfjlsjflj————————————————");
        return integer;
    }

    @GetMapping(path = "/myfavorite")
    public List<Route> myFavorite() {

        System.out.println("进入myfavorite啊啊啊啊啊");
        List<Route> list = userService.myfavorite(8);
        System.out.println(list);
        return list;

    }
}
