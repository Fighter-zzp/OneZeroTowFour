package com.travel.one.four.service.impl;


import com.travel.one.four.dao.NavDao;
import com.travel.one.four.domain.Nav;
import com.travel.one.four.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavServiceImpl implements NavService {
    @Autowired
    private NavDao navDao;
    @Override
    public List<Nav> findNavAll() {
        return navDao.findNavAll();
    }

}
