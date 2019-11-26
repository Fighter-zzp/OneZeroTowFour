package com.travel.one.four.service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.travel.one.four.domain.Company;

import java.util.List;

public interface CompanyService {
    Company selectBySname(String sname,String password);
    void insertCompany(Company company);
    List<Company> findAll();
    Integer updata(Company company);
    Company login(String sname,String password);
    List<Company> show(Integer sid);
}
