package com.pnc.gamestore.common.validators.gamevalidators;

import com.pnc.gamestore.common.validators.Validator;
import com.pnc.gamestore.model.Platform;

import java.util.Set;

public class PlatformAmountValidator implements Validator {
    private final Set<Platform> platforms;

    public PlatformAmountValidator(Set<Platform> platforms) {
        this.platforms = platforms;
    }

    @Override
    public boolean validate(){
        return platforms != null && !platforms.isEmpty();
    }
}
