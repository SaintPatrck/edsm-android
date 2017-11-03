package com.phapps.elitedangerous.edsm.requests;

import com.phapps.elitedangerous.edsm.annotations.PeriodType;

public class GetCommanderCreditsRequest extends BaseCommanderRequest {
    @PeriodType
    private String mPeriod;

    @PeriodType
    public String getPeriod() {
        return mPeriod;
    }

    public void setPeriod(@PeriodType String period) {
        mPeriod = period;
    }
}
