package com.phapps.elitedangerous.eddb.callbacks;

import com.phapps.elitedangerous.eddb.dto.InventoryItemDto;

public interface GetCommanderInventoryCallbacks extends EdsmCallbacks {
    void onSuccess(InventoryItemDto[] materials);

    void onFail(String message);
}
