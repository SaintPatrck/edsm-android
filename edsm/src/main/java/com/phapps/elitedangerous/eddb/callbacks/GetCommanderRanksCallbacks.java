package com.phapps.elitedangerous.eddb.callbacks;

import com.phapps.elitedangerous.eddb.dto.CommanderDto;

public interface GetCommanderRanksCallbacks extends EdsmCallbacks {
    void onSuccess(CommanderDto commander);

    void onFail(String message);
}
