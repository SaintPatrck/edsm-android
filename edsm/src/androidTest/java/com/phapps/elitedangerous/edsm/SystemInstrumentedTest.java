/*
 * Copyright (c) 2017.
 *
 * Copyright 2017 Patrick Honkonen
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.phapps.elitedangerous.edsm;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.phapps.elitedangerous.edsm.callbacks.GetCelestialBodiesInSystemCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetFactionsInSystemCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetStationsInSystemCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetSystemInfoCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetSystemsInAreaCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.PlanRouteCallbacks;
import com.phapps.elitedangerous.edsm.dto.SystemBodiesDto;
import com.phapps.elitedangerous.edsm.dto.SystemDistanceDto;
import com.phapps.elitedangerous.edsm.dto.SystemDto;
import com.phapps.elitedangerous.edsm.dto.SystemFactionsDto;
import com.phapps.elitedangerous.edsm.dto.SystemJumpDto;
import com.phapps.elitedangerous.edsm.dto.SystemStationsDto;
import com.phapps.elitedangerous.edsm.requests.GetCelestialBodiesInSystemRequest;
import com.phapps.elitedangerous.edsm.requests.GetFactionsInSystemRequest;
import com.phapps.elitedangerous.edsm.requests.GetStationsInSystemRequest;
import com.phapps.elitedangerous.edsm.requests.GetSystemInfoRequest;
import com.phapps.elitedangerous.edsm.requests.GetSystemsInAreaRequest;
import com.phapps.elitedangerous.edsm.requests.PlanRouteRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class SystemInstrumentedTest {

    private static final String TAG = SystemInstrumentedTest.class.getName();

    @Before
    public void setUp() throws Exception {
        EdsmClient.init(InstrumentationRegistry.getTargetContext());
        // The test endpoint does not always return reliable results so we use the production endpoint.
        EdsmClient.getInstance().setServer(EdsmClient.Server.Production);
        EdsmClient.getInstance().setLoggingEnabled(true);
    }

    @Test
    public void testGetSystemDetails_SingleSystem() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);
        List<String> systemNames = new ArrayList<>();
        systemNames.add("Ma");

        GetSystemInfoRequest request = new GetSystemInfoRequest()
                .setSystemNames(systemNames);

        request.setIncludeHidden(true)
                .setShowCoordinates(true)
                .setShowId(true)
                .setShowInformation(true)
                .setShowPermit(true)
                .setShowPrimaryStar(true);

        EdsmClient.getInstance().getSystemDetails(request, new GetSystemInfoCallbacks() {
            @Override
            public void onSuccess(SystemDto[] system) {
                Log.d(TAG, "onSuccess() called with: system = [" + Arrays.toString(system) + "]");
                assertTrue(system.length > 0);
                signal.countDown();
            }

            @Override
            public void onFail(String message) {
                fail(message);
            }

            @Override
            public void onError() {
                fail();
            }
        });

        signal.await(10L, TimeUnit.SECONDS);
    }

    @Test
    public void testGetSystemDetails_ManySystems() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);
        final List<String> systemNames = new ArrayList<>();
        systemNames.add("Col 285 Sector GJ-E b13-3");
        systemNames.add("Col 285 Sector UK-N c7-16");
        systemNames.add("Col 285 Sector GJ-E b13-1");
        systemNames.add("Col 285 Sector KS-T d3-119");
        systemNames.add("Col 285 Sector QE-P c6-21");
        systemNames.add("Col 285 Sector OV-A b15-6");
        systemNames.add("Col 285 Sector IX-T d3-53");
        systemNames.add("Col 285 Sector KS-T d3-61");
        systemNames.add("Col 285 Sector SP-N c7-13");
        systemNames.add("HIP 98967");
        systemNames.add("Col 285 Sector MA-B b15-5");

        GetSystemInfoRequest request = new GetSystemInfoRequest()
                .setSystemNames(systemNames);

        request.setIncludeHidden(true)
                .setShowCoordinates(true)
                .setShowId(true)
                .setShowInformation(true)
                .setShowPermit(true)
                .setShowPrimaryStar(true);

        EdsmClient.getInstance().getSystemDetails(request, new GetSystemInfoCallbacks() {
            @Override
            public void onSuccess(SystemDto[] system) {
                Log.d(TAG, "onSuccess() called with: system = [" + Arrays.toString(system) + "]");
                assertEquals(systemNames.size(), system.length);
                signal.countDown();
            }

            @Override
            public void onFail(String message) {
                fail(message);
            }

            @Override
            public void onError() {
                fail();
            }
        });

        signal.await(10L, TimeUnit.SECONDS);
    }

    @Test
    public void testGetSystemsInArea_Sphere() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        GetSystemsInAreaRequest request = new GetSystemsInAreaRequest()
                .setSystemName("Chelmen")
                .setShape(GetSystemsInAreaRequest.SHAPE_SPHERE)
                .setRadius((double)150)
                .setMinRadius((double)20);

        EdsmClient.getInstance().getSystemsInArea(request, new GetSystemsInAreaCallbacks() {
            @Override
            public void onSuccess(SystemDistanceDto[] systemDistances) {
                Log.d(TAG, "onSuccess() called with: system = [" + Arrays.toString(systemDistances) + "]");
                signal.countDown();
            }

            @Override
            public void onFail(String message) {
                fail(message);
            }

            @Override
            public void onError() {
                fail();
            }
        });

        signal.await(10L, TimeUnit.SECONDS);
    }

    @Test
    public void testPlanRoute() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        PlanRouteRequest request = new PlanRouteRequest();
        request.setStartSystem("Sol");
        request.setEndSystem("Achali");
        request.setMaxJumpRange(25);

        EdsmClient.getInstance().planRoute(request, new PlanRouteCallbacks() {
            @Override
            public void onSuccess(SystemJumpDto[] systems) {
                assertNotNull(systems);
                assertTrue(systems.length > 0);
            }

            @Override
            public void onFail(String error) {
                fail(error);
            }

            @Override
            public void onError() {
                fail();
            }
        });

        signal.await(10L, TimeUnit.SECONDS);
    }

    @Test
    public void testGetCelestialBodies() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        GetCelestialBodiesInSystemRequest request = new GetCelestialBodiesInSystemRequest();
        request.setSystemName("Chelmen");

        EdsmClient.getInstance().getCelestialBodiesInSystem(request, new GetCelestialBodiesInSystemCallbacks() {
            @Override
            public void onSuccess(SystemBodiesDto systemBodies) {
                assertNotNull(systemBodies);
            }

            @Override
            public void onFail(String error) {
                fail(error);
            }

            @Override
            public void onError() {
                fail();
            }
        });

        signal.await(10L, TimeUnit.SECONDS);
    }

    @Test
    public void testGetStations() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        GetStationsInSystemRequest request = new GetStationsInSystemRequest();
        request.setSystemName("Sol");

        EdsmClient.getInstance().getStationsInSystem(request, new GetStationsInSystemCallbacks() {
            @Override
            public void onSuccess(SystemStationsDto stations) {
                assertNotNull(stations);
            }

            @Override
            public void onFail(String error) {
                fail(error);
            }

            @Override
            public void onError() {
                fail();
            }
        });

        signal.await(10L, TimeUnit.SECONDS);
    }

    @Test
    public void testGetFactions() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        GetFactionsInSystemRequest request = new GetFactionsInSystemRequest();
        request.setSystemName("Achali");
        request.setShowHistory(true);

        EdsmClient.getInstance().getFactionsInSystem(request, new GetFactionsInSystemCallbacks() {
            @Override
            public void onSuccess(SystemFactionsDto factions) {
                assertNotNull(factions);
            }

            @Override
            public void onFail(String error) {
                fail(error);
            }

            @Override
            public void onError() {
                fail();
            }
        });

        signal.await(10L, TimeUnit.SECONDS);
    }
}
