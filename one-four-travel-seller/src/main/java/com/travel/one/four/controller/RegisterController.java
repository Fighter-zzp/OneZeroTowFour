package com.travel.one.four.controller;

import com.travel.one.four.domain.Company;
import com.travel.one.four.domain.Msg;
import com.travel.one.four.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/insertCompany")
    @ResponseBody
    public Map<String, Integer> insertCompany(Company company) {
        Map<String, Integer> map = new HashMap<>();
        String sname = company.getSname();
        String password = company.getPassword();
        Company integer = companyService.selectBySname(sname, password);
        if (integer != null) {
            map.put("result", 1);
        } else {
            companyService.insertCompany(company);
            map.put("result", 0);
        }
        return map;
    }

    @PostMapping("/updata")
    @ResponseBody
    public Map<String, Integer> updata(Company company, HttpSession httpSession) {
        Company login = (Company) httpSession.getAttribute("login");
        Integer sid = login.getSid();
        company.setSid(sid);
        HashMap<String, Integer> map = new HashMap<>();
        Integer updata = companyService.updata(company);
        if (updata == 1) {
            map.put("result", 1);
        } else {
            map.put("result", 0);
        }
        return map;
    }

    @RequestMapping("/denglu")
    @ResponseBody
    public Map<String, Integer> login(String sname, String password, HttpSession httpSession) {
        HashMap<String, Integer> map = new HashMap<>();
        Company login = companyService.login(sname, password);
        if (login == null) {
            map.put("result", 0);
        } else {
            httpSession.setAttribute("login", login);
            map.put("result", 1);
        }
        return map;
    }

    @RequestMapping("/companyList")
    public Company list(String sname, String password) {
        Company company = companyService.selectBySname(sname, password);
        return company;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Map<String, Integer> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("result", 1);
        return map;
    }


    @RequestMapping("/show")
    @ResponseBody
    public List<Company> showList(HttpSession httpSession) {
        Company login = (Company) httpSession.getAttribute("login");
        Integer sid1 = login.getSid();
        List<Company> show = companyService.show(sid1);
        return show;
    }

    public String fileupload(MultipartFile upload, HttpServletRequest request) throws IOException {
        System.out.println("fileupload.......");
        //上传路径
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFiles");
        System.out.println("realPath");

        //判断路径是否存在
        File path = new File(realPath);
        if (!path.exists()) {
            path.mkdirs();
        }

        //解决文件重名问题
        String fileName = upload.getOriginalFilename();//上传文件的名称
        String uuid = UUID.randomUUID().toString().replace("_", "");

        fileName = uuid + "_" + fileName;

        //调用MultiPartFile的transferTo()完成文件上传
        upload.transferTo(new File(realPath, fileName));


        return "success";
    }

    @RequestMapping("/showName")
    @ResponseBody
    public Msg showName(HttpSession session){
        var login = session.getAttribute("login");
        return Msg.sucess().add("login", login);
    }
}
