package com.phapps.elitedangerous.edsm.callbacks;

import com.phapps.elitedangerous.edsm.dto.SystemBodiesDto;

public interface GetCelestialBodiesInSystemCallbacks extends EdsmCallbacks {
    void onSuccess(SystemBodiesDto systemBodies);

    void onFail(String error);
}
