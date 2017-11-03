package com.phapps.elitedangerous.edsm.callbacks;

public interface SellCommanderShipCallbacks extends EdsmCallbacks {
    void onSuccess();

    void onFail(String message);
}
