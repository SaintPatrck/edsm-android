package com.phapps.elitedangerous.edsm.annotations;

import android.support.annotation.StringDef;

import com.phapps.elitedangerous.edsm.constants.TimePeriod;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({
        TimePeriod.ONE_MONTH,
        TimePeriod.SEVEN_DAYS,
        TimePeriod.SIX_MONTHS,
        TimePeriod.THREE_MONTHS
})
@Retention(RetentionPolicy.SOURCE)
public @interface PeriodType {
}
