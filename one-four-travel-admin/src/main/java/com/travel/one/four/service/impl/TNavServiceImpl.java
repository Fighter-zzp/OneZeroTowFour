package com.travel.one.four.service.impl;

import com.travel.one.four.domain.TNav;
import com.travel.one.four.domain.TRoute;
import com.travel.one.four.domain.plus.NavsFav;
import com.travel.one.four.mapper.TNavMapper;
import com.travel.one.four.mapper.TRouteMapper;
import com.travel.one.four.service.ITNavService;
import com.travel.one.four.utils.ExtendQueryObject;
import com.travel.one.four.utils.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TNavServiceImpl implements ITNavService {
    @Autowired
    private TNavMapper tNavMapper;
    @Autowired
    private TRouteMapper tRouteMapper;

    @Override
    public List<NavsFav> findAll() {
        return tNavMapper.findAll();
    }

    @Override
    public void updateOrInsert(Integer cid, String cname) {
        var tNav = new TNav();
        tNav.setCname(cname);
        if (cid>0){
            tNav.setCid(cid);
            tNavMapper.updateByPrimaryKeySelective(tNav);
        }else {
            tNavMapper.insertSelective(tNav);
        }
    }

    @Override
    public void banByCid(Integer cid, Integer status) {
        tNavMapper.updateByCid(cid, status);
    }

    @Override
    public TNav findByCid(Integer cid) {
        return tNavMapper.selectByPrimaryKey(cid);
    }

    @Override
    public List<TRoute> pageFindByCid(ExtendQueryObject qo) {
        return tRouteMapper.pageFindByCid(qo);
    }

    @Override
    public void deleteCAndR(Integer cid, Integer rid) {

    }

    @Override
    public void ban(Integer rid, Integer status) {
        tRouteMapper.updateFlagByRid(status,rid);
    }

    @Override
    public List<TNav> findAllInfo(QueryObject qo) {
        return tNavMapper.findAllInfo(qo);
    }
}
