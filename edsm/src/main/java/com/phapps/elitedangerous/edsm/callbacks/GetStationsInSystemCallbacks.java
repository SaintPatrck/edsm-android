package com.phapps.elitedangerous.edsm.callbacks;

import com.phapps.elitedangerous.edsm.dto.SystemStationsDto;

public interface GetStationsInSystemCallbacks extends EdsmCallbacks {
    void onSuccess(SystemStationsDto stations);

    void onFail(String error);
}
