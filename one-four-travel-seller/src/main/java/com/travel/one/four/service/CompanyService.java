package com.travel.one.four.service;

import com.travel.one.four.domain.Company;

import java.util.List;

public interface CompanyService {
    Integer checkSname(String sname);
    void insertCompany(Company company);
    List<Company> findAll();
}
