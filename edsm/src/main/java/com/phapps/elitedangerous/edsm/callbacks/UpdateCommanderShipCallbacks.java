package com.phapps.elitedangerous.edsm.callbacks;

public interface UpdateCommanderShipCallbacks extends EdsmCallbacks {
    void onSuccess();

    void onFail(String message);
}
