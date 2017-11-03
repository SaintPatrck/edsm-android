package com.phapps.elitedangerous.edsm.callbacks;

import com.phapps.elitedangerous.edsm.dto.InventoryItemDto;

public interface SetCommanderMaterialsCallbacks extends EdsmCallbacks {
    void onSuccess(InventoryItemDto[] materials);

    void onFail(String message);
}
