package com.travel.one.four.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class TRoute implements Serializable {
    private Integer rid;

    private String rname;

    private Double price;

    private String routeintroduce;

    private String rflag;

    private String rdate;

    private String isthemetour;

    private Integer count;

    private Integer cid;

    private String rimage;

    private Integer sid;

    private String sourceid;

    private static final long serialVersionUID = 1L;
}