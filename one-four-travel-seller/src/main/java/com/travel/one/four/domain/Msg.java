package com.travel.one.four.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回json格式数据通用类
 */
@Data
public class Msg {
    //状态码 100-成功 200-失败
    private int code;
    //提示信息
    private String message;
    //用户要返回给浏览器的数据
    private Map<String,Object> extend=new HashMap<String, Object>();

    public static Msg sucess(){
        Msg result=new Msg();
        result.setCode(100);
        result.setMessage("成功");
        return result;
    }
    public static Msg fail(){
        Msg result=new Msg();
        result.setCode(200);
        result.setMessage("失败");
        return result;
    }
    public Msg add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

}
