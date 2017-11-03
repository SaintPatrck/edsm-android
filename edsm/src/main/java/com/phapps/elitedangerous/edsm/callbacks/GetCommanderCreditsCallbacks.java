package com.phapps.elitedangerous.edsm.callbacks;

import com.phapps.elitedangerous.edsm.dto.CreditsDto;

public interface GetCommanderCreditsCallbacks extends EdsmCallbacks {
    void onSuccess(CreditsDto[] creditSummary);

    void onFail(String message);
}
