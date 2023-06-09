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

