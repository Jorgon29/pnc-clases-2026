package com.pnc.gamestore.common.validators.gamevalidators;

import com.pnc.gamestore.common.validators.Validator;

import java.time.Year;

public class YearValidator implements Validator {

    private int publishYear;
    public YearValidator(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public YearValidator() {
        this.publishYear = -1;
    }

    @Override
    public boolean validate() {
        if(publishYear == -1) return true;
        return publishYear <= Year.now().getValue() && publishYear >= 1975;
    }
}
