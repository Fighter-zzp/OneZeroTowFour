package com.travel.one.four.dao;


import com.travel.one.four.domain.Nav;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavDao {

    /**
     * 查询所有功能导航菜单
     * @return
     */
    public List<Nav> findNavAll();



}
