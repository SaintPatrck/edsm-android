package com.phapps.elitedangerous.eddb.callbacks;

public interface SetCommanderRanksCallbacks extends EdsmCallbacks {
    void onSuccess();

    void onFail(String message);
}
