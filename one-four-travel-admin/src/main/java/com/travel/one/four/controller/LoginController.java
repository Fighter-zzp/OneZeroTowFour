package com.travel.one.four.controller;

import com.travel.one.four.domain.TUser;
import com.travel.one.four.service.ITUserService;
import com.travel.one.four.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private ITUserService itUserService;

    @GetMapping("/checkAdmin")
    public Msg checkAdmin(String username, String password, HttpSession session){
        var tUser = itUserService.checkLogin(username, password);
        var msg = new Msg();
        if (tUser!=null) {
            session.setAttribute("admin",tUser);
            return Msg.sucess();
        }
        msg.setMessage("失败，账户密码错误或者您不是admin");
        msg.setCode(200);
        return msg;
    }

    @GetMapping("/home")
    public Msg home(){
        return Msg.sucess().add("count",itUserService.count());
    }

    @GetMapping("logOut")
    public void loginOut(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath()+"/pages/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("showName")
    public Msg showName(HttpSession session){
        var user = (TUser)session.getAttribute("admin");
        var msg = Msg.sucess();
        msg.setMessage(user.getUsername());
        return msg;
    }
}
