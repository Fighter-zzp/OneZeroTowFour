package com.travel.one.four.dao;

import com.travel.one.four.domain.Company;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao {
    void insertCompany(Company company);
    List<Company>  findAll();
    Integer updata(Company company);
    Company selectBySname(@Param("sname") String sname,@Param("password") String password);
    List<Company> show(Integer sid);
}
