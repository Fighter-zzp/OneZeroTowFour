package com.travel.one.four.service;


import com.travel.one.four.domain.Nav;

import java.util.List;


public interface NavService {
    /**
     * 查询所有功能导航菜单
     * @return
     */
    public List<Nav> findNavAll();


}
