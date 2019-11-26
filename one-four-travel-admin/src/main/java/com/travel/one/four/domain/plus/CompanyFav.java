package com.travel.one.four.domain.plus;

import com.travel.one.four.domain.TCompanydata;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@NoArgsConstructor
public class CompanyFav extends TCompanydata {
    private Integer favCount;
}
