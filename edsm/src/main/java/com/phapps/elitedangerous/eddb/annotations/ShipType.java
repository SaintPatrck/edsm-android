package com.phapps.elitedangerous.eddb.annotations;

import android.support.annotation.StringDef;

import com.phapps.elitedangerous.eddb.constants.Ship;

@StringDef({
        Ship.EMPIRE_TRADE,
        Ship.FEDERATION_DROPSHIP,
        Ship.VULTURE
})
public @interface ShipType {
}
