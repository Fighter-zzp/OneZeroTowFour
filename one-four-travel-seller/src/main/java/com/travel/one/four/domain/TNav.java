package com.travel.one.four.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class TNav implements Serializable {
    private Integer cid;

    private String cname;

    private Integer status;

    private static final long serialVersionUID = 1L;
}