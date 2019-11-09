package com.travel.one.four.service.Impl;

import com.travel.one.four.dao.CompanyDao;
import com.travel.one.four.domain.Company;
import com.travel.one.four.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findService")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    /**
     * 查询是用户名是否存在返回一个int'类型
     * @param sname
     * @return
     */
    @Override
    public Integer checkSname(String sname) {
        Integer count = companyDao.checkSname(sname);

        return count;
    }

    /**
     * 新增商家
     * @param company
     */
    @Override
    public void insertCompany(Company company) {
        companyDao.insertCompany(company);
    }


    /**
     * 查询所有商家
     * @return
     */
    @Override
    public List<Company> findAll() {
        List<Company> list = companyDao.findAll();
        return list;
    }
}
