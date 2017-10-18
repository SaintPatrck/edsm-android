package com.phapps.elitedangerous.eddb.callbacks;

public interface SetCommanderCreditsCallbacks extends EdsmCallbacks {
    void onSuccess();

    void onFail(String message);
}
