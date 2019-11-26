package com.travel.one.four;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.one.four.domain.TNav;
import com.travel.one.four.domain.TRoute;
import com.travel.one.four.domain.plus.CompanyFav;
import com.travel.one.four.mapper.TNavMapper;
import com.travel.one.four.mapper.TRouteMapper;
import com.travel.one.four.mapper.TUserMapper;
import com.travel.one.four.service.ITCompanyDataService;
import com.travel.one.four.service.ITFavoriteService;
import com.travel.one.four.service.ITNavService;
import com.travel.one.four.utils.ExtendQueryObject;
import com.travel.one.four.utils.Msg;
import com.travel.one.four.utils.QueryObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {
    @Autowired
    private TUserMapper tUserMapper;
    @Autowired
    private TRouteMapper tRouteMapper;
    @Autowired
    private ITFavoriteService itFavoriteService;
    @Autowired
    private ITCompanyDataService itCompanyDataService;

    @Test
    public void demo1(){
        var count = tUserMapper.findCount();
        System.out.println(count);
    }

    @Test
    public void demo2(){
        tUserMapper.deleteByIds(new Integer[]{27,29});
    }
    @Test
    public void demo3(){
        var qo = new ExtendQueryObject();
        qo.setUid(2);
        qo.setKeyword("广西");
        var list = itFavoriteService.findByUid(qo);
        list.forEach(System.out::println);
    }

    @Test
    public void demo4(){
        var qo = new QueryObject();
        var list = itCompanyDataService.findAll(qo);
        list.forEach(System.out::println);
    }

    @Test
    public void demo5(){
        tRouteMapper.updateFlagByRid(1,1);
    }

    @Test
    public void demo6(){
        PageHelper.startPage(3,6);
        var qo = new ExtendQueryObject();
        qo.setUid(2);
        var allByUid = itFavoriteService.findByUid(qo);
        var pageInfo = new PageInfo<TRoute>(allByUid, 3);
        pageInfo.getList().forEach(System.out::println);
    }

    @Autowired
    private ITNavService itNavService;
    @Autowired
    private TNavMapper tNavMapper;
    @Test
    public void demo7(){
        tNavMapper.findAll().forEach(System.out::println);
    }

    @Test
    public void demo8(){
        var qo = new ExtendQueryObject();
        qo.setCid(1);
        itNavService.pageFindByCid(qo).forEach(System.out::println);
    }

    @Test
    public void demo9(){
        PageHelper.startPage(1,3);
        var allInfo = tNavMapper.findAllInfo(new QueryObject());
        var objectPageInfo = new PageInfo<TNav>(allInfo,3);
        objectPageInfo.getList().forEach(System.out::println);
    }

    @Test
    public void demo10(){
        PageHelper.startPage(1,3);
        var allInfo = tRouteMapper.findAllInfo(new QueryObject());
        var objectPageInfo = new PageInfo(allInfo,3);
        objectPageInfo.getList().forEach(System.out::println);
    }
}
