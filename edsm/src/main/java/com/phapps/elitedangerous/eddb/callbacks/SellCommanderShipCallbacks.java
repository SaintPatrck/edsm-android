package com.phapps.elitedangerous.eddb.callbacks;

public interface SellCommanderShipCallbacks extends EdsmCallbacks {
    void onSuccess();

    void onFail(String message);
}
