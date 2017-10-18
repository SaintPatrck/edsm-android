package com.phapps.elitedangerous.eddb.requests;

import com.phapps.elitedangerous.eddb.annotations.PeriodType;

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
