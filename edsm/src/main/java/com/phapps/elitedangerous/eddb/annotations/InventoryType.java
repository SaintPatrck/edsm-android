package com.phapps.elitedangerous.eddb.annotations;

import android.support.annotation.StringDef;

import com.phapps.elitedangerous.eddb.constants.Inventory;

@StringDef({
        Inventory.CARGO,
        Inventory.DATA,
        Inventory.MATERIALS
})
public @interface InventoryType {
}
