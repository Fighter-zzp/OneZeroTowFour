package com.travel.one.four.domain;

import java.io.Serializable;

public class Favorite implements Serializable {
    private Integer rid;
    private Integer uid;

    public Favorite() {
    }

    public Favorite(Integer rid, Integer uid) {
        this.rid = rid;
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "rid=" + rid +
                ", uid=" + uid +
                '}';
    }
}
