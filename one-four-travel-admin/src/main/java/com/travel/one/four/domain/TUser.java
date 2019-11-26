package com.travel.one.four.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TUser implements Serializable {
    private Integer uid;

    private String username;

    private String password;

    private String name;

    private String birthday;

    private String sex;

    private String telephone;

    private String email;

    private Boolean isAdmin;

    private String status;

    private String code;

    private static final long serialVersionUID = 1L;
}