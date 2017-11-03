package com.phapps.elitedangerous.edsm.annotations;

import android.support.annotation.StringDef;

import com.phapps.elitedangerous.edsm.constants.Ship;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({
        Ship.EMPIRE_TRADE,
        Ship.FEDERATION_DROPSHIP,
        Ship.VULTURE
})
@Retention(RetentionPolicy.SOURCE)
public @interface ShipType {
}
