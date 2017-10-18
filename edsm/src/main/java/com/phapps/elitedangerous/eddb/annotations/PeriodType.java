package com.phapps.elitedangerous.eddb.annotations;

import android.support.annotation.StringDef;

import com.phapps.elitedangerous.eddb.constants.TimePeriod;

@StringDef({
        TimePeriod.ONE_MONTH,
        TimePeriod.SEVEN_DAYS,
        TimePeriod.SIX_MONTHS,
        TimePeriod.THREE_MONTHS
})
public @interface PeriodType {
}
