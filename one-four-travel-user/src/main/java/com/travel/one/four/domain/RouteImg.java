package com.travel.one.four.domain;

import java.io.Serializable;

/**
 * 此类是点击首页显示的介绍图片跳转的资源类
 */
public class RouteImg implements Serializable {
    private Integer rgid;
    private Integer rid;
    private String bigPic;
    private String smallPic;
    private Integer isPromote;
    private String routeImgUrl;

    public RouteImg() {
    }

    public RouteImg(Integer rgid, Integer rid, String bigPic, String smallPic, Integer isPromote, String routeImgUrl) {
        this.rgid = rgid;
        this.rid = rid;
        this.bigPic = bigPic;
        this.smallPic = smallPic;
        this.isPromote = isPromote;
        this.routeImgUrl = routeImgUrl;
    }

    public Integer getRgid() {
        return rgid;
    }

    public void setRgid(Integer rgid) {
        this.rgid = rgid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public Integer getIsPromote() {
        return isPromote;
    }

    public void setIsPromote(Integer isPromote) {
        this.isPromote = isPromote;
    }

    public String getRouteImgUrl() {
        return routeImgUrl;
    }

    public void setRouteImgUrl(String routeImgUrl) {
        this.routeImgUrl = routeImgUrl;
    }

    @Override
    public String toString() {
        return "RouteImg{" +
                "rgid=" + rgid +
                ", rid=" + rid +
                ", bigPic='" + bigPic + '\'' +
                ", smallPic='" + smallPic + '\'' +
                ", isPromote=" + isPromote +
                ", routeImgUrl='" + routeImgUrl + '\'' +
                '}';
    }
}
