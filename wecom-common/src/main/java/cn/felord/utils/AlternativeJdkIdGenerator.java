/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 字符串生成器.
 *
 * @author dax
 * @since 2021 /11/22 11:41
 */
public class AlternativeJdkIdGenerator {
    private final Random random;

    /**
     * Instantiates a new Alternative jdk id generator.
     */
    public AlternativeJdkIdGenerator() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] seed = new byte[8];
        secureRandom.nextBytes(seed);
        this.random = new Random((new BigInteger(seed)).longValue());
    }

    /**
     * 生成32位随机字符串
     *
     * @return the string
     */
    public String generate32() {
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

        return doGenerate32(mostSigBits, leastSigBits);
    }


    private String doGenerate32(long mostSigBits, long leastSigBits) {
        return (digits(mostSigBits >> 32, 8) +
                digits(mostSigBits >> 16, 4) +
                digits(mostSigBits, 4) +
                digits(leastSigBits >> 48, 4) +
                digits(leastSigBits, 12));
    }

    private static String digits(long val, int digits) {
        long hi = 1L << (digits * 4);
        return Long.toHexString(hi | (val & (hi - 1))).substring(1);
    }
}

