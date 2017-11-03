package com.phapps.elitedangerous.edsm.annotations;

import android.support.annotation.StringDef;

import com.phapps.elitedangerous.edsm.constants.Inventory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({
        Inventory.CARGO,
        Inventory.DATA,
        Inventory.MATERIALS
})
@Retention(RetentionPolicy.SOURCE)
public @interface InventoryType {
}
