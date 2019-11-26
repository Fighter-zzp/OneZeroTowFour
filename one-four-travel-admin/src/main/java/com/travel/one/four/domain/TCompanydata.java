package com.travel.one.four.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class TCompanydata implements Serializable {
    private Integer sid;

    private String sname;

    private String password;

    private String email;

    private String consphone;

    private String address;

    private String status;

    private String introduction;

//    private List<TRoute> routeList;

    private static final long serialVersionUID = 1L;
}