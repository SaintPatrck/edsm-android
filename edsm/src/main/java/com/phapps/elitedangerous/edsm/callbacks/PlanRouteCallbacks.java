package com.phapps.elitedangerous.edsm.callbacks;

import com.phapps.elitedangerous.edsm.dto.SystemJumpDto;

public interface PlanRouteCallbacks extends EdsmCallbacks {
    void onSuccess(SystemJumpDto[] jumps);

    void onFail(String error);
}
