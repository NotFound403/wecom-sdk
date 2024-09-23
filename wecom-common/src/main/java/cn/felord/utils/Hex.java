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

import java.nio.ByteBuffer;


/**
 * Converts hexadecimal Strings.
 * <p>
 * This class is thread-safe.
 *
 * @since 1.1
 */
public class Hex {

    /**
     * Used to build output as hex.
     */
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f'};

    /**
     * Used to build output as hex.
     */
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F'};


    /**
     * Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
     * The returned array will be double the length of the passed array, as it takes two characters to represent any
     * given byte.
     *
     * @param data a byte[] to convert to hex characters
     * @return A char[] containing lower-case hexadecimal characters
     */
    public static char[] encodeHex(final byte[] data) {
        return encodeHex(data, true);
    }

    /**
     * Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
     * The returned array will be double the length of the passed array, as it takes two characters to represent any
     * given byte.
     *
     * @param data        a byte[] to convert to Hex characters
     * @param toLowerCase {@code true} converts to lowercase, {@code false} to uppercase
     * @return A char[] containing hexadecimal characters in the selected case
     * @since 1.4
     */
    public static char[] encodeHex(final byte[] data, final boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    /**
     * Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
     * The returned array will be double the length of the passed array, as it takes two characters to represent any
     * given byte.
     *
     * @param data     a byte[] to convert to hex characters
     * @param toDigits the output alphabet (must contain at least 16 chars)
     * @return A char[] containing the appropriate characters from the alphabet For best results, this should be either         upper- or lower-case hex.
     * @since 1.4
     */
    protected static char[] encodeHex(final byte[] data, final char[] toDigits) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        encodeHex(data, 0, data.length, toDigits, out, 0);
        return out;
    }

    /**
     * Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
     *
     * @param data        a byte[] to convert to hex characters
     * @param dataOffset  the position in {@code data} to start encoding from
     * @param dataLen     the number of bytes from {@code dataOffset} to encode
     * @param toLowerCase {@code true} converts to lowercase, {@code false} to uppercase
     * @return A char[] containing the appropriate characters from the alphabet For best results, this should be either         upper- or lower-case hex.
     * @since 1.15
     */
    public static char[] encodeHex(final byte[] data, final int dataOffset, final int dataLen,
                                   final boolean toLowerCase) {
        final char[] out = new char[dataLen << 1];
        encodeHex(data, dataOffset, dataLen, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER, out, 0);
        return out;
    }

    /**
     * Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
     *
     * @param data        a byte[] to convert to hex characters
     * @param dataOffset  the position in {@code data} to start encoding from
     * @param dataLen     the number of bytes from {@code dataOffset} to encode
     * @param toLowerCase {@code true} converts to lowercase, {@code false} to uppercase
     * @param out         a char[] which will hold the resultant appropriate characters from the alphabet.
     * @param outOffset   the position within {@code out} at which to start writing the encoded characters.
     * @since 1.15
     */
    public static void encodeHex(final byte[] data, final int dataOffset, final int dataLen,
                                 final boolean toLowerCase, final char[] out, final int outOffset) {
        encodeHex(data, dataOffset, dataLen, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER, out, outOffset);
    }

    /**
     * Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
     *
     * @param data       a byte[] to convert to hex characters
     * @param dataOffset the position in {@code data} to start encoding from
     * @param dataLen    the number of bytes from {@code dataOffset} to encode
     * @param toDigits   the output alphabet (must contain at least 16 chars)
     * @param out        a char[] which will hold the resultant appropriate characters from the alphabet.
     * @param outOffset  the position within {@code out} at which to start writing the encoded characters.
     */
    private static void encodeHex(final byte[] data, final int dataOffset, final int dataLen, final char[] toDigits,
                                  final char[] out, final int outOffset) {
        // two characters form the hex value.
        for (int i = dataOffset, j = outOffset; i < dataOffset + dataLen; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
    }

    /**
     * Converts a byte buffer into an array of characters representing the hexadecimal values of each byte in order. The
     * returned array will be double the length of the passed array, as it takes two characters to represent any given
     * byte.
     *
     * <p>All bytes identified by {@link ByteBuffer#remaining()} will be used; after this method
     * the value {@link ByteBuffer#remaining() remaining()} will be zero.</p>
     *
     * @param data a byte buffer to convert to hex characters
     * @return A char[] containing lower-case hexadecimal characters
     * @since 1.11
     */
    public static char[] encodeHex(final ByteBuffer data) {
        return encodeHex(data, true);
    }

    /**
     * Converts a byte buffer into an array of characters representing the hexadecimal values of each byte in order. The
     * returned array will be double the length of the passed array, as it takes two characters to represent any given
     * byte.
     *
     * <p>All bytes identified by {@link ByteBuffer#remaining()} will be used; after this method
     * the value {@link ByteBuffer#remaining() remaining()} will be zero.</p>
     *
     * @param data        a byte buffer to convert to hex characters
     * @param toLowerCase {@code true} converts to lowercase, {@code false} to uppercase
     * @return A char[] containing hexadecimal characters in the selected case
     * @since 1.11
     */
    public static char[] encodeHex(final ByteBuffer data, final boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    /**
     * Converts a byte buffer into an array of characters representing the hexadecimal values of each byte in order. The
     * returned array will be double the length of the passed array, as it takes two characters to represent any given
     * byte.
     *
     * <p>All bytes identified by {@link ByteBuffer#remaining()} will be used; after this method
     * the value {@link ByteBuffer#remaining() remaining()} will be zero.</p>
     *
     * @param byteBuffer a byte buffer to convert to hex characters
     * @param toDigits   the output alphabet (must be at least 16 characters)
     * @return A char[] containing the appropriate characters from the alphabet For best results, this should be either         upper- or lower-case hex.
     * @since 1.11
     */
    protected static char[] encodeHex(final ByteBuffer byteBuffer, final char[] toDigits) {
        return encodeHex(toByteArray(byteBuffer), toDigits);
    }

    /**
     * Converts an array of bytes into a String representing the hexadecimal values of each byte in order. The returned
     * String will be double the length of the passed array, as it takes two characters to represent any given byte.
     *
     * @param data a byte[] to convert to hex characters
     * @return A String containing lower-case hexadecimal characters
     * @since 1.4
     */
    public static String encodeHexString(final byte[] data) {
        return new String(encodeHex(data));
    }

    /**
     * Converts an array of bytes into a String representing the hexadecimal values of each byte in order. The returned
     * String will be double the length of the passed array, as it takes two characters to represent any given byte.
     *
     * @param data        a byte[] to convert to hex characters
     * @param toLowerCase {@code true} converts to lowercase, {@code false} to uppercase
     * @return A String containing lower-case hexadecimal characters
     * @since 1.11
     */
    public static String encodeHexString(final byte[] data, final boolean toLowerCase) {
        return new String(encodeHex(data, toLowerCase));
    }

    /**
     * Converts a byte buffer into a String representing the hexadecimal values of each byte in order. The returned
     * String will be double the length of the passed array, as it takes two characters to represent any given byte.
     *
     * <p>All bytes identified by {@link ByteBuffer#remaining()} will be used; after this method
     * the value {@link ByteBuffer#remaining() remaining()} will be zero.</p>
     *
     * @param data a byte buffer to convert to hex characters
     * @return A String containing lower-case hexadecimal characters
     * @since 1.11
     */
    public static String encodeHexString(final ByteBuffer data) {
        return new String(encodeHex(data));
    }

    /**
     * Converts a byte buffer into a String representing the hexadecimal values of each byte in order. The returned
     * String will be double the length of the passed array, as it takes two characters to represent any given byte.
     *
     * <p>All bytes identified by {@link ByteBuffer#remaining()} will be used; after this method
     * the value {@link ByteBuffer#remaining() remaining()} will be zero.</p>
     *
     * @param data        a byte buffer to convert to hex characters
     * @param toLowerCase {@code true} converts to lowercase, {@code false} to uppercase
     * @return A String containing lower-case hexadecimal characters
     * @since 1.11
     */
    public static String encodeHexString(final ByteBuffer data, final boolean toLowerCase) {
        return new String(encodeHex(data, toLowerCase));
    }

    /**
     * Convert the byte buffer to a byte array. All bytes identified by
     * {@link ByteBuffer#remaining()} will be used.
     *
     * @param byteBuffer the byte buffer
     * @return the byte[]
     */
    private static byte[] toByteArray(final ByteBuffer byteBuffer) {
        final int remaining = byteBuffer.remaining();
        // Use the underlying buffer if possible
        if (byteBuffer.hasArray()) {
            final byte[] byteArray = byteBuffer.array();
            if (remaining == byteArray.length) {
                byteBuffer.position(remaining);
                return byteArray;
            }
        }
        // Copy the bytes
        final byte[] byteArray = new byte[remaining];
        byteBuffer.get(byteArray);
        return byteArray;
    }
}

