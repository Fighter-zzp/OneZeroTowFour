package com.travel.one.four.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TFavorite implements Serializable {
    private Integer rid;

    private Integer uid;

    private Date date;

    private static final long serialVersionUID = 1L;
}