package com.phapps.elitedangerous.eddb.callbacks;

import com.phapps.elitedangerous.eddb.EdsmClient;
import com.phapps.elitedangerous.eddb.requests.UpdateCommanderShipRequest;

public interface SetCommanderCurrentShipCallbacks extends EdsmCallbacks {
    /**
     * @param inDatabase State if the current ship is in the EDSM database already, or if you need
     * to add the ship type using {@link EdsmClient#updateCommanderShip(UpdateCommanderShipRequest,
     * UpdateCommanderShipCallbacks)}
     */
    void onSuccess(Boolean inDatabase);

    void onFail(String message);
}
