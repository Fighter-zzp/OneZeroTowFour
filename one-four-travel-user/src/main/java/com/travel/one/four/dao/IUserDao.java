package com.travel.one.four.dao;

import com.travel.one.four.domain.Route;
import com.travel.one.four.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface IUserDao {
    /**
     * 查询用户是否存在
     * @param username
     * @return
     */
    public User findByName(String username);

    /**
     * 验证用户登录
     * @param username
     * @param password
     * @return
     */
    public User login(@Param("username") String username,@Param("password") String password);


    /**
     * 传递用户对象注册用户
     * @param user
     */
    public Integer registerUser(User user);



    //根据登录用户的id查询自己的个人信息
    List<User> getList();

    /*  Integer imgSet(User user);*/
    //修改密码
    Integer setPassword(String password);

    //展示收藏(测试用的方法)
    List<Route> getCollect();
    //点击图片后把rid（应该还有用户id）保存到favorite表中
    Integer saveTwoId(@Param("rid") Integer rid, @Param("uid") Integer uid);
    //点击获取rid  然后根据两个id进行添加（就是根据两个id进行查询）
    List<Route>  myfavorite(Integer uid);
}
