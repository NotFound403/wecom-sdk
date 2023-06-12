/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class AlternativeJdkIdGenerator {
    private final Random random;

    public AlternativeJdkIdGenerator() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] seed = new byte[8];
        secureRandom.nextBytes(seed);
        this.random = new Random((new BigInteger(seed)).longValue());
    }

    public String generateId() {
        byte[] randomBytes = new byte[16];
        this.random.nextBytes(randomBytes);
        long mostSigBits = 0L;

        for (int i = 0; i < 8; ++i) {
            mostSigBits = mostSigBits << 8 | (long) (randomBytes[i] & 255);
        }

        long leastSigBits = 0L;

        for (int i = 8; i < 16; ++i) {
            leastSigBits = leastSigBits << 8 | (long) (randomBytes[i] & 255);
        }

        return new UUID(mostSigBits, leastSigBits).toString();
    }
}

