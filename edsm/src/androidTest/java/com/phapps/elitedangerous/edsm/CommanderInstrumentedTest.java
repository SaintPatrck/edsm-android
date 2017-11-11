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

import com.phapps.elitedangerous.edsm.callbacks.GetCommanderCreditsCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetCommanderInventoryCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetCommanderRanksCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.SellCommanderShipCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.SetCommanderCreditsCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.SetCommanderCurrentShipCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.SetCommanderMaterialsCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.SetCommanderRanksCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.UpdateCommanderShipCallbacks;
import com.phapps.elitedangerous.edsm.constants.Inventory;
import com.phapps.elitedangerous.edsm.constants.Ship;
import com.phapps.elitedangerous.edsm.constants.TimePeriod;
import com.phapps.elitedangerous.edsm.dto.CommanderDto;
import com.phapps.elitedangerous.edsm.dto.CreditsDto;
import com.phapps.elitedangerous.edsm.dto.InventoryItemDto;
import com.phapps.elitedangerous.edsm.dto.ProgressDto;
import com.phapps.elitedangerous.edsm.dto.RanksDto;
import com.phapps.elitedangerous.edsm.requests.GetCommanderCreditsRequest;
import com.phapps.elitedangerous.edsm.requests.GetCommanderInventoryRequest;
import com.phapps.elitedangerous.edsm.requests.SellCommanderShipRequest;
import com.phapps.elitedangerous.edsm.requests.SetCommanderCreditsRequest;
import com.phapps.elitedangerous.edsm.requests.SetCommanderCurrentShipRequest;
import com.phapps.elitedangerous.edsm.requests.SetCommanderInventoryRequest;
import com.phapps.elitedangerous.edsm.requests.SetCommanderRanksRequest;
import com.phapps.elitedangerous.edsm.requests.UpdateCommanderShipRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class CommanderInstrumentedTest {
    @Before
    public void setUp() throws Exception {
        EdsmClient.init(InstrumentationRegistry.getTargetContext());
        // The test endpoint does not return the expected results so we use the production endpoint instead.
        EdsmClient.getInstance().setServer(EdsmClient.Server.Production);
    }

    @Test
    public void testGetCommanderRanks_NoApiKey_PrivateProfile() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        EdsmClient api = EdsmClient.getInstance();
        api.getCommanderRanks(TestConstants.COMMANDER_NAME, null, new GetCommanderRanksCallbacks() {
            @Override
            public void onSuccess(CommanderDto commander) {
                assertNotNull(commander);
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

        signal.await();
    }

    @Test
    public void testGetCommanderRanks_NoApiKey_PublicProfile() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        EdsmClient api = EdsmClient.getInstance();
        api.getCommanderRanks(TestConstants.COMMANDER_NAME, null, new GetCommanderRanksCallbacks() {
            @Override
            public void onSuccess(CommanderDto commander) {
                assertNotNull(commander);
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

        signal.await();
    }

    @Test
    public void testGetCommanderRanks_ApiKey_PrivateProfile() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        EdsmClient api = EdsmClient.getInstance();
        api.getCommanderRanks(TestConstants.COMMANDER_NAME, TestConstants.API_KEY,
                new GetCommanderRanksCallbacks() {
                    @Override
                    public void onSuccess(CommanderDto commander) {
                        assertNotNull(commander);
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

        signal.await();
    }

    @Test
    public void testGetCommanderRanks_ApiKey_PublicProfile() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        EdsmClient api = EdsmClient.getInstance();
        api.getCommanderRanks(TestConstants.COMMANDER_NAME, TestConstants.API_KEY,
                new GetCommanderRanksCallbacks() {
                    @Override
                    public void onSuccess(CommanderDto commander) {
                        assertNotNull(commander);
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

        signal.await();
    }

    @Test
    public void testSetCommanderRanks_Fail_NoApiKey() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        SetCommanderRanksRequest request = new SetCommanderRanksRequest();
        request.setCommanderName(TestConstants.COMMANDER_NAME);
        request.setApiKey(null);
        request.setCombatRank(1);
        request.setCombatRank(50);

        EdsmClient api = EdsmClient.getInstance();
        api.setCommanderRanks(request, new SetCommanderRanksCallbacks() {
            @Override
            public void onSuccess() {
                fail();
            }

            @Override
            public void onFail(String message) {
                assertNotNull(message);
                signal.countDown();
            }

            @Override
            public void onError() {
                fail();
            }
        });

        signal.await();
    }

    @Test
    public void testSetCommanderRanks_Success() throws Exception {
        final CountDownLatch signal = new CountDownLatch(2);

        final int expectedRank = 3;
        final int expectedProgress = 14;
        SetCommanderRanksRequest request = new SetCommanderRanksRequest();
        request.setCommanderName(TestConstants.COMMANDER_NAME);
        request.setApiKey(TestConstants.API_KEY);
        request.setCombatRank(expectedRank);
        request.setCombatProgress(expectedProgress);

        final EdsmClient api = EdsmClient.getInstance();
        api.setCommanderRanks(request, new SetCommanderRanksCallbacks() {
            @Override
            public void onSuccess() {
                signal.countDown();

                api.getCommanderRanks(TestConstants.COMMANDER_NAME, TestConstants.API_KEY,
                        new GetCommanderRanksCallbacks() {
                            @Override
                            public void onSuccess(CommanderDto commander) {
                                assertNotNull(commander);

                                assertNotNull(commander.getRanks());
                                RanksDto ranks = commander.getRanks();
                                assertEquals(expectedRank, ranks.getCombat());

                                assertNotNull(commander.getProgress());
                                ProgressDto progress = commander.getProgress();
                                assertEquals(expectedProgress, progress.getCombat());

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

        signal.await();
    }

    @Test
    public void testGetCommanderCredits_NoPeriod() throws Exception {
        final CountDownLatch signal = new CountDownLatch(2);

        Random random = new Random();
        final Long expectedBalance = Math.abs(random.nextLong());
        final Long expectedLoan = Math.abs(random.nextLong());

        SetCommanderCreditsRequest setCommanderCreditsRequest = new SetCommanderCreditsRequest();
        setCommanderCreditsRequest.setApiKey(TestConstants.API_KEY);
        setCommanderCreditsRequest.setCommanderName(TestConstants.COMMANDER_NAME);
        setCommanderCreditsRequest.setBalance(expectedBalance);
        setCommanderCreditsRequest.setLoan(expectedLoan);

        final EdsmClient api = EdsmClient.getInstance();
        api.setCommanderCredits(setCommanderCreditsRequest, new SetCommanderCreditsCallbacks() {
            @Override
            public void onSuccess() {
                // set credits success
                signal.countDown();

                GetCommanderCreditsRequest request = new GetCommanderCreditsRequest();
                request.setCommanderName(TestConstants.COMMANDER_NAME);
                request.setApiKey(TestConstants.API_KEY);
                api.getCommanderCredits(request, new GetCommanderCreditsCallbacks() {
                    @Override
                    public void onSuccess(CreditsDto[] creditSummary) {
                        assertNotNull(creditSummary);
                        assertEquals(1, creditSummary.length);

                        CreditsDto credits = creditSummary[0];
                        assertEquals(expectedBalance, credits.getBalance());
                        assertEquals(expectedLoan, credits.getLoan());
                        assertNotNull(credits.getDate());
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

        signal.await();
    }

    @Test
    public void testGetCommanderCredits_ValidPeriod() throws Exception {

        final CountDownLatch signal = new CountDownLatch(3);

        final Random random = new Random();
        final Long expectedBalance1 = Math.abs(random.nextLong());
        final Long expectedLoan1 = Math.abs(random.nextLong());

        SetCommanderCreditsRequest setCommanderCreditsRequest = new SetCommanderCreditsRequest();
        setCommanderCreditsRequest.setApiKey(TestConstants.API_KEY);
        setCommanderCreditsRequest.setCommanderName(TestConstants.COMMANDER_NAME);
        setCommanderCreditsRequest.setBalance(expectedBalance1);
        setCommanderCreditsRequest.setLoan(expectedLoan1);

        final EdsmClient api = EdsmClient.getInstance();
        api.setCommanderCredits(setCommanderCreditsRequest, new SetCommanderCreditsCallbacks() {
            @Override
            public void onSuccess() {
                // first set credits success
                signal.countDown();

                try {
                    // delay 5 seconds to play nice with the servers.
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    // ignore
                }

                final Long expectedBalance2 = Math.abs(random.nextLong());
                final Long expectedLoan2 = Math.abs(random.nextLong());

                SetCommanderCreditsRequest setCommanderCreditsRequest =
                        new SetCommanderCreditsRequest();
                setCommanderCreditsRequest.setApiKey(TestConstants.API_KEY);
                setCommanderCreditsRequest.setCommanderName(TestConstants.COMMANDER_NAME);
                setCommanderCreditsRequest.setBalance(expectedBalance2);
                setCommanderCreditsRequest.setLoan(expectedLoan2);

                api.setCommanderCredits(setCommanderCreditsRequest,
                        new SetCommanderCreditsCallbacks() {
                            @Override
                            public void onSuccess() {
                                // second set credits success
                                signal.countDown();

                                try {
                                    // don't abuse the servers... too much
                                    Thread.sleep(5 * 1000);
                                } catch (InterruptedException e) {
                                    // ignore
                                }

                                GetCommanderCreditsRequest request =
                                        new GetCommanderCreditsRequest();
                                request.setCommanderName(TestConstants.COMMANDER_NAME);
                                request.setApiKey(TestConstants.API_KEY);
                                request.setPeriod(TimePeriod.THREE_MONTHS);

                                api.getCommanderCredits(request,
                                        new GetCommanderCreditsCallbacks() {
                                            @Override
                                            public void onSuccess(CreditsDto[] creditSummary) {
                                                assertNotNull(creditSummary);
                                                assertTrue(creditSummary.length > 1);
                                                signal.countDown();
                                            }

                                            @Override
                                            public void onFail(String message) {
                                                fail("Get Credits Fail: " + message);
                                            }

                                            @Override
                                            public void onError() {
                                                fail("Get Credits Error");
                                            }
                                        });
                            }

                            @Override
                            public void onFail(String message) {
                                fail("Set Credits 3 Fail: " + message);
                            }

                            @Override
                            public void onError() {
                                fail("Set Credits 2 Error");
                            }
                        });
            }

            @Override
            public void onFail(String message) {
                fail("Set Credits 1 Fail: " + message);
            }

            @Override
            public void onError() {
                fail("Set Credits 1 Error");
            }
        });

        signal.await();
    }

    @Test
    public void testUpdateCommanderShip() throws Exception {
        final CountDownLatch signal = new CountDownLatch(2);

        UpdateCommanderShipRequest request = new UpdateCommanderShipRequest();
        request.setCommanderName(TestConstants.COMMANDER_NAME);
        request.setApiKey(TestConstants.API_KEY);
        request.setShipId(0);
        request.setShipName("Test Ship");
        request.setShipIdent("TS-001");
        request.setType(Ship.VULTURE);

        final EdsmClient api = EdsmClient.getInstance();
        api.updateCommanderShip(request, new UpdateCommanderShipCallbacks() {
            @Override
            public void onSuccess() {
                signal.countDown();

                SetCommanderCurrentShipRequest request = new SetCommanderCurrentShipRequest();
                request.setCommanderName(TestConstants.COMMANDER_NAME);
                request.setApiKey(TestConstants.API_KEY);
                request.setShipId(0);

                api.setCommanderCurrentShipId(request, new SetCommanderCurrentShipCallbacks() {
                    @Override
                    public void onSuccess(Boolean inDatabase) {
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

        signal.await();
    }

    @Test
    public void testSellCommanderShip() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        SellCommanderShipRequest request = new SellCommanderShipRequest();
        request.setCommanderName(TestConstants.COMMANDER_NAME);
        request.setApiKey(TestConstants.API_KEY);
        request.setShipId(0);

        EdsmClient api = EdsmClient.getInstance();
        api.sellCommanderShip(request, new SellCommanderShipCallbacks() {
            @Override
            public void onSuccess() {
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

        signal.await();
    }

    @Test
    public void testSetGetCommanderMaterials() throws Exception {
        final CountDownLatch signal = new CountDownLatch(2);
        final EdsmClient api = EdsmClient.getInstance();

        final Integer expectedChromiumQty = 28;
        final Integer expectedZincQty = 18;

        SetCommanderInventoryRequest setRequest = new SetCommanderInventoryRequest();
        setRequest.setCommanderName(TestConstants.COMMANDER_NAME);
        setRequest.setApiKey(TestConstants.API_KEY);
        setRequest.setType(Inventory.MATERIALS);

        Map<String, Integer> values = new HashMap<>();
        values.put("chromium", expectedChromiumQty);
        values.put("zinc", expectedZincQty);

        setRequest.setValues(values);

        api.setCommanderInventory(setRequest, new SetCommanderMaterialsCallbacks() {
            @Override
            public void onSuccess(InventoryItemDto[] materials) {

                CountDownLatch materialsCounter = new CountDownLatch(2);
                for (InventoryItemDto dto : materials) {
                    if (dto.getType().equals("chromium")) {
                        assertEquals(expectedChromiumQty, dto.getQuantity());
                        materialsCounter.countDown();
                    }

                    if (dto.getType().equals("zinc")) {
                        assertEquals(expectedZincQty, dto.getQuantity());
                        materialsCounter.countDown();
                    }
                }
                assertEquals(0, materialsCounter.getCount());

                signal.countDown();

                GetCommanderInventoryRequest getRequest = new GetCommanderInventoryRequest();
                getRequest.setCommanderName(TestConstants.COMMANDER_NAME);
                getRequest.setApiKey(TestConstants.API_KEY);
                getRequest.setType(Inventory.MATERIALS);

                api.getCommanderInventory(getRequest, new GetCommanderInventoryCallbacks() {
                    @Override
                    public void onSuccess(InventoryItemDto[] materials) {
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

        signal.await();
    }

    @Test
    public void testSetGetCommanderEncodedData() throws Exception {
        final CountDownLatch signal = new CountDownLatch(2);

        final EdsmClient api = EdsmClient.getInstance();

        final String expectedDataName = "thargoid sensor data";
        final int expectedDataCount = 1;
        final Integer expectedDataQty = 1;

        SetCommanderInventoryRequest setRequest = new SetCommanderInventoryRequest();
        setRequest.setCommanderName(TestConstants.COMMANDER_NAME);
        setRequest.setApiKey(TestConstants.API_KEY);
        setRequest.setType(Inventory.DATA);

        Map<String, Integer> values = new HashMap<>();
        values.put(expectedDataName, expectedDataQty);

        setRequest.setValues(values);

        api.setCommanderInventory(setRequest, new SetCommanderMaterialsCallbacks() {
            @Override
            public void onSuccess(InventoryItemDto[] materials) {
                CountDownLatch dataCounter = new CountDownLatch(1);
                for (InventoryItemDto dto : materials) {
                    if (dto.getName().equals(expectedDataName)) {
                        assertEquals(expectedDataQty, dto.getQuantity());
                        dataCounter.countDown();
                    }
                }
                assertEquals(expectedDataCount, dataCounter.getCount());

                signal.countDown();

                GetCommanderInventoryRequest getRequest = new GetCommanderInventoryRequest();
                getRequest.setCommanderName(TestConstants.COMMANDER_NAME);
                getRequest.setApiKey(TestConstants.API_KEY);
                getRequest.setType(Inventory.DATA);

                api.getCommanderInventory(getRequest, new GetCommanderInventoryCallbacks() {
                    @Override
                    public void onSuccess(InventoryItemDto[] materials) {
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

        signal.await();
    }

    @Test
    public void testSetGetCommanderCargo() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);
        final EdsmClient api = EdsmClient.getInstance();

        final String expectedCargoName = "fruits & vegetables";
        final Integer expectedCargoQty = 28;

        SetCommanderInventoryRequest setRequest = new SetCommanderInventoryRequest();
        setRequest.setCommanderName(TestConstants.COMMANDER_NAME);
        setRequest.setApiKey(TestConstants.API_KEY);
        setRequest.setType(Inventory.MATERIALS);

        Map<String, Integer> values = new HashMap<>();
        values.put(expectedCargoName, expectedCargoQty);

        setRequest.setValues(values);

        api.setCommanderInventory(setRequest, new SetCommanderMaterialsCallbacks() {
            @Override
            public void onSuccess(InventoryItemDto[] materials) {

                CountDownLatch materialsCounter = new CountDownLatch(2);
                for (InventoryItemDto dto : materials) {
                    if (dto.getType().equals(expectedCargoName)) {
                        assertEquals(expectedCargoQty, dto.getQuantity());
                        materialsCounter.countDown();
                    }
                }
                signal.countDown();

                GetCommanderInventoryRequest getRequest = new GetCommanderInventoryRequest();
                getRequest.setCommanderName(TestConstants.COMMANDER_NAME);
                getRequest.setApiKey(TestConstants.API_KEY);
                getRequest.setType(Inventory.MATERIALS);

                api.getCommanderInventory(getRequest, new GetCommanderInventoryCallbacks() {
                    @Override
                    public void onSuccess(InventoryItemDto[] materials) {
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

        signal.await();
    }
}
