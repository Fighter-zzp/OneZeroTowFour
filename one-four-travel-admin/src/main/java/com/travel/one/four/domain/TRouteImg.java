package com.travel.one.four.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class TRouteImg implements Serializable {
    private Integer rgid;

    private Integer rid;

    private String bigpic;

    private String smallpic;

    private static final long serialVersionUID = 1L;
}