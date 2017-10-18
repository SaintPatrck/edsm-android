package com.phapps.elitedangerous.eddb.callbacks;

import com.phapps.elitedangerous.eddb.dto.SystemDto;

public interface GetSystemInfoCallbacks extends EdsmCallbacks {
    void onSuccess(SystemDto[] system);

    void onFail(String message);
}
