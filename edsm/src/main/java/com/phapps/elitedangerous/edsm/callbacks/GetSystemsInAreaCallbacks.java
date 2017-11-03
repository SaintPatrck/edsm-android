package com.phapps.elitedangerous.edsm.callbacks;

import com.phapps.elitedangerous.edsm.dto.SystemDistanceDto;

public interface GetSystemsInAreaCallbacks extends EdsmCallbacks {

    void onSuccess(SystemDistanceDto[] systemDistances);

    void onFail(String message);

}
