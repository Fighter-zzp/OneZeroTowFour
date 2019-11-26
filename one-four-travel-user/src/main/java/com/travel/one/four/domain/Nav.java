package com.travel.one.four.domain;

import java.io.Serializable;

/**
 * 首页功能导航类
 */
public class Nav implements Serializable {
    private Integer cid;
    private String cname;
    private String url;
    private String slogan;

    public Nav() {
    }

    public Nav(Integer cid, String cname, String url, String slogan) {
        this.cid = cid;
        this.cname = cname;
        this.url = url;
        this.slogan = slogan;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @Override
    public String toString() {
        return "Nav{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", url='" + url + '\'' +
                ", slogan='" + slogan + '\'' +
                '}';
    }
}
