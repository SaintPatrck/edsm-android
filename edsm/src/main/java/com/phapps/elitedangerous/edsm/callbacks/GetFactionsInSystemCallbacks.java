package com.phapps.elitedangerous.edsm.callbacks;

import com.phapps.elitedangerous.edsm.dto.SystemFactionsDto;

public interface GetFactionsInSystemCallbacks extends EdsmCallbacks {
    void onSuccess(SystemFactionsDto factions);

    void onFail(String error);
}
