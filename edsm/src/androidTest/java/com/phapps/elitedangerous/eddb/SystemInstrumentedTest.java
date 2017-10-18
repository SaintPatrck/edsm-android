package com.phapps.elitedangerous.eddb;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.phapps.elitedangerous.eddb.requests.GetSystemInfoRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class SystemInstrumentedTest {

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

        signal.await(10L, TimeUnit.SECONDS);
    }
}
