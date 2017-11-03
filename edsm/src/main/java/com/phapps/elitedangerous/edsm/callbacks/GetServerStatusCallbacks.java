package com.phapps.elitedangerous.edsm.callbacks;

import com.phapps.elitedangerous.edsm.dto.ServerStatusDto;

public interface GetServerStatusCallbacks extends EdsmCallbacks {
    void onSuccess(ServerStatusDto status);
}
