package com.travel.one.four.mapper;

import com.travel.one.four.domain.TCompanydata;
import com.travel.one.four.domain.plus.CompanyFav;
import com.travel.one.four.utils.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCompanydataMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(TCompanydata record);

    int insertSelective(TCompanydata record);

    TCompanydata selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(TCompanydata record);

    int updateByPrimaryKey(TCompanydata record);

    int findCount();

    List<CompanyFav> findAll(QueryObject qo);

    Integer stopBySid(Integer sid);

    Integer startBySid(Integer sid);

    CompanyFav findBySid(Integer sid);

    int deleteBySidAndRid(@Param("sid") Integer sid, @Param("rid")Integer rid);
}