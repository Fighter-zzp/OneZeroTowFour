package com.travel.one.four.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class ExtendQueryObject extends QueryObject{
    private Integer uid;
    private Integer sid;
    private Integer cid;
}
