package com.pnc.gamestore.common.validators.gamevalidators;

import com.pnc.gamestore.common.Classification;
import com.pnc.gamestore.common.validators.Validator;
import com.pnc.gamestore.model.Platform;

import java.util.Set;

public class NintendoValidator implements Validator {
    Classification classification;
    Set<Platform> platforms;
    public NintendoValidator(Classification classification, Set<Platform> platforms) {
        this.classification = classification;
        this.platforms = platforms;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public NintendoValidator() {}

    @Override
    public boolean validate() {
        if(classification == null || classification != Classification.M) {return true;};

        for (Platform platform : platforms) {
            if (platform.getCompany().equalsIgnoreCase("nintendo")){
                return false;
            }
        }

        return true;
    }
}
