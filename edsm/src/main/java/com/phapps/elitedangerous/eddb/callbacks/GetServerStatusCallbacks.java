package com.phapps.elitedangerous.eddb.callbacks;

import com.phapps.elitedangerous.eddb.dto.ServerStatusDto;

public interface GetServerStatusCallbacks extends EdsmCallbacks {
    void onSuccess(ServerStatusDto status);
}
