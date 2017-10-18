package com.phapps.elitedangerous.eddb.callbacks;

public interface UpdateCommanderShipCallbacks extends EdsmCallbacks {
    void onSuccess();

    void onFail(String message);
}
