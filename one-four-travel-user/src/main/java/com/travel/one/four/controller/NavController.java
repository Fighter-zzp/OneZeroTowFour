package com.travel.one.four.controller;


import com.travel.one.four.domain.Nav;
import com.travel.one.four.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nav")
public class NavController {
    @Autowired
    private NavService navService;
    @GetMapping("/findNavAll")
    public List<Nav> findNavAll(){
        List<Nav> navAll = navService.findNavAll();
        for(Nav n:navAll){
            System.out.println(n);
        }
        return navAll;
    }



}
