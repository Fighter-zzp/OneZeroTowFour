package com.travel.one.four.domain;

import java.io.Serializable;
import java.util.Date;

public class Place implements Serializable {
    private Integer pid;
    private String pname;
    private String purl;
    private Integer navId;
    private Date creatTime;

    public Place() {
    }

    public Place(Integer pid, String pname, String purl, Integer navId, Date creatTime) {
        this.pid = pid;
        this.pname = pname;
        this.purl = purl;
        this.navId = navId;
        this.creatTime = creatTime;
    }

    public Integer getNavId() {
        return navId;
    }

    public void setNavId(Integer navId) {
        this.navId = navId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "Place{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", purl='" + purl + '\'' +
                ", navId=" + navId +
                ", creatTime=" + creatTime +
                '}';
    }
}
