package com.travel.one.four.domain.plus;

import com.travel.one.four.domain.TUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class UserFav extends TUser {
    private Integer favCount;
}
