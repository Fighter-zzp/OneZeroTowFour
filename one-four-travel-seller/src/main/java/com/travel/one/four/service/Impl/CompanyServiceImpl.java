package com.travel.one.four.service.Impl;

import com.travel.one.four.dao.CompanyDao;
import com.travel.one.four.domain.Company;
import com.travel.one.four.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    /**
     * 查询是用户名是否存在返回一个int'类型
     *
     * @param sname
     * @return
     */

    @Override
    public Company selectBySname(String sname, String password) {
        Company list = companyDao.selectBySname(sname, password);
        return list;
    }

    /**
     * 新增商家
     *
     * @param company
     */

    @Override
    public void insertCompany(Company company) {
        companyDao.insertCompany(company);
    }

    /**
     * 查询所有商家
     *
     * @return
     */
    @Override
    public List<Company> findAll() {
        List<Company> list = companyDao.findAll();
        return list;
    }

    @Override
    public Integer updata(Company company) {
        Integer updata = companyDao.updata(company);
        return updata;
    }

    @Override
    public Company login(String sname, String password) {
        Company company = companyDao.selectBySname(sname, password);
        System.out.println("company:" + company);
        return company;
    }

    @Override
    public List<Company> show(Integer sid) {
        List<Company> show = companyDao.show(sid);
        return show;
    }
}
