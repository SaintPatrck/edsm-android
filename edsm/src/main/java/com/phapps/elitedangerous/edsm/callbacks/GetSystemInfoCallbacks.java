package com.phapps.elitedangerous.edsm.callbacks;

import com.phapps.elitedangerous.edsm.dto.SystemDto;

public interface GetSystemInfoCallbacks extends EdsmCallbacks {
    void onSuccess(SystemDto[] system);

    void onFail(String message);
}
