package com.travel.one.four.dao;

import com.travel.one.four.domain.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao {
    Integer checkSname(String sname);
    void insertCompany(Company company);
    List<Company>  findAll();
}
