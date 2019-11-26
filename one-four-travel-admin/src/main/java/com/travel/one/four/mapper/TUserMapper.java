package com.travel.one.four.mapper;

import com.travel.one.four.domain.TUser;
import com.travel.one.four.domain.plus.UserFav;
import com.travel.one.four.utils.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    TUser checkLogin(@Param("username") String username, @Param("password") String password);

    List<Integer> findCount();

    List<UserFav> findAll(QueryObject qo);

    void deleteByIds(@Param("ids")Integer[] ids);

    UserFav findByUid(Integer uid);
}