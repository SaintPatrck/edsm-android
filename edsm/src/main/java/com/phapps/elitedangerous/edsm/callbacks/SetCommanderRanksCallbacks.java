package com.phapps.elitedangerous.edsm.callbacks;

public interface SetCommanderRanksCallbacks extends EdsmCallbacks {
    void onSuccess();

    void onFail(String message);
}
