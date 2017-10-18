package com.phapps.elitedangerous.eddb.callbacks;

import com.phapps.elitedangerous.eddb.dto.CreditsDto;

public interface GetCommanderCreditsCallbacks extends EdsmCallbacks {
    void onSuccess(CreditsDto[] creditSummary);

    void onFail(String message);
}
