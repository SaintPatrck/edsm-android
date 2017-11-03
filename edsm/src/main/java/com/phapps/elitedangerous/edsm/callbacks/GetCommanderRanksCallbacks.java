package com.phapps.elitedangerous.edsm.callbacks;

import com.phapps.elitedangerous.edsm.dto.CommanderDto;

public interface GetCommanderRanksCallbacks extends EdsmCallbacks {
    void onSuccess(CommanderDto commander);

    void onFail(String message);
}
