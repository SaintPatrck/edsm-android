package com.phapps.elitedangerous.edsm.annotations;

import android.support.annotation.StringDef;

import com.phapps.elitedangerous.edsm.constants.CelestialBody;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({CelestialBody.PLANET, CelestialBody.STAR})
@Retention(RetentionPolicy.SOURCE)
public @interface CelestialBodyType {
}
