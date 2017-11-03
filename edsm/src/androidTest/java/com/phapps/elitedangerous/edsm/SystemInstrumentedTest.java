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
import com.phapps.elitedangerous.edsm.dto.CoordinatesDto;
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
    }

    @Test
    public void testGetSystemDetails_SingleSystem() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);
        List<String> systemNames = new ArrayList<>();
        systemNames.add("Achali");

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
                assertEquals(1, system.length);
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
        List<String> systemNames = new ArrayList<>();
        systemNames.add("Achali");
        systemNames.add("Sol");

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
                assertEquals(2, system.length);
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
                .setCoordinates(new CoordinatesDto(50.34375, 27.4375, 112.28125))
                .setShape(GetSystemsInAreaRequest.SHAPE_SPHERE)
                .setRadius((double)10);

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
        request.setSystemName("Sol");

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
