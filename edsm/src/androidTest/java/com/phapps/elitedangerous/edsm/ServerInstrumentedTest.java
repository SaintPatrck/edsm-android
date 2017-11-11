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

import com.phapps.elitedangerous.edsm.callbacks.GetServerStatusCallbacks;
import com.phapps.elitedangerous.edsm.dto.ServerStatusDto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class ServerInstrumentedTest {

    @Before
    public void setUp() throws Exception {
        EdsmClient.init(InstrumentationRegistry.getTargetContext());
        // The test endpoint does not return the expected results so we use the production endpoint instead.
        EdsmClient.getInstance().setServer(EdsmClient.Server.Production);
    }

    @Test
    public void testGetServerStatus() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);
        EdsmClient api = EdsmClient.getInstance();
        api.getServerStatus(new GetServerStatusCallbacks() {
            @Override
            public void onSuccess(ServerStatusDto status) {
                assertNotNull(status);
                assertNotNull(status.getLastUpdate());
                assertNotNull(status.getMessage());
                assertNotNull(status.getType());
                assertNotNull(status.getMessage());
                signal.countDown();
            }

            @Override
            public void onError() {
                fail();
            }
        });

        signal.await();
    }
}
