package com.phapps.elitedangerous.edsm.callbacks;

public interface SetCommanderCreditsCallbacks extends EdsmCallbacks {
    void onSuccess();

    void onFail(String message);
}
