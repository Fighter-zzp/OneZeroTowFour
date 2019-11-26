package com.travel.one.four.service.impl;

import com.travel.one.four.domain.TCompanydata;
import com.travel.one.four.domain.TRoute;
import com.travel.one.four.domain.plus.CompanyFav;
import com.travel.one.four.mapper.TCompanydataMapper;
import com.travel.one.four.mapper.TRouteMapper;
import com.travel.one.four.service.ITCompanyDataService;
import com.travel.one.four.utils.ExtendQueryObject;
import com.travel.one.four.utils.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TCompanyDataServiceImpl implements ITCompanyDataService {
    @Autowired
    private TCompanydataMapper tCompanydataMapper;
    @Autowired
    private TRouteMapper tRouteMapper;

    @Override
    public List<CompanyFav> findAll(QueryObject qo) {
        return tCompanydataMapper.findAll(qo);
    }

    @Override
    public void updateOrInsert(TCompanydata company) {
        if (company.getSid()>0){
            tCompanydataMapper.updateByPrimaryKeySelective(company);
        }else {
            tCompanydataMapper.insertSelective(company);
        }
    }

    @Override
    public void stop(Integer sid,Integer status) {
        if (status==0){
            tCompanydataMapper.stopBySid(sid);
        }else {
            tCompanydataMapper.startBySid(sid);
        }
    }

    @Override
    public CompanyFav findBySid(Integer sid) {
        return tCompanydataMapper.findBySid(sid);
    }

    @Override
    public List<TRoute> pageFindBySid(ExtendQueryObject qo) {
        return tRouteMapper.pageFindBySid(qo);
    }

    @Override
    public void deleteCAndR(Integer sid,Integer rid){
        tCompanydataMapper.deleteBySidAndRid(sid, rid);
    }

    @Override
    public void ban(Integer rid, Integer status) {
        tRouteMapper.updateFlagByRid(status,rid);
    }

}
