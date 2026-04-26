package com.pnc.gamestore.common;

import java.time.Year;

public class MaxCurrentYearValidator {
    public boolean ValidateMaxCurrentYear(Integer year){
        if(year == null){ return false; }
        return year <= Year.now().getValue();
    }
}
