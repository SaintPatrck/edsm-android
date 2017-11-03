package com.phapps.elitedangerous.edsm.requests;

public abstract class BaseSystemRequest {
    private boolean mShowId;
    private boolean mShowCoordinates;
    private boolean mShowPermit;
    private boolean mShowInformation;
    private boolean mShowPrimaryStar;

    public boolean showId() {
        return mShowId;
    }

    public BaseSystemRequest setShowId(boolean showId) {
        mShowId = showId;
        return this;
    }

    public boolean showCoords() {
        return mShowCoordinates;
    }

    public BaseSystemRequest setShowCoordinates(boolean showCoordinates) {
        mShowCoordinates = showCoordinates;
        return this;
    }

    public boolean showPermit() {
        return mShowPermit;
    }

    public BaseSystemRequest setShowPermit(boolean showPermit) {
        mShowPermit = showPermit;
        return this;
    }

    public boolean showInformation() {
        return mShowInformation;
    }

    public BaseSystemRequest setShowInformation(boolean showInformation) {
        mShowInformation = showInformation;
        return this;
    }

    public boolean showPrimaryStar() {
        return mShowPrimaryStar;
    }

    public BaseSystemRequest setShowPrimaryStar(boolean showPrimaryStar) {
        mShowPrimaryStar = showPrimaryStar;
        return this;
    }
}
