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

package com.phapps.elitedangerous.edsm.requests;

public class SetCommanderCreditsRequest extends BaseCommanderRequest {
    private Long mBalance;
    private Long mLoan;

    public Long getBalance() {
        return mBalance;
    }

    public void setBalance(Long balance) {
        mBalance = balance;
    }

    public Long getLoan() {
        return mLoan;
    }

    public void setLoan(Long loan) {
        mLoan = loan;
    }
}
