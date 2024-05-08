package de.jpdigital.maven.plugins.hibernate5ddl.tests.packageannotations.types;

import java.util.BitSet;

/**
 *
 * @author <a href="mailto:jens.pelzetter@googlemail.com">Jens Pelzetter</a>
 */
public class BitSetHelper {

    public static final String DELIMITER = ",";

    public static final byte[] BYTES = new byte[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static String bitSetToString(BitSet bitSet) {
        StringBuilder builder = new StringBuilder();
        for (long token : bitSet.toLongArray()) {
            if (builder.length() > 0) {
                builder.append(DELIMITER);
            }
            builder.append(Long.toString(token, 2));
        }
        return builder.toString();
    }

    public static BitSet stringToBitSet(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        String[] tokens = string.split(DELIMITER);
        long[] values = new long[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            values[i] = Long.valueOf(tokens[i], 2);
        }
        return BitSet.valueOf(values);
    }

    public static byte[] bitSetToBytes(BitSet bitSet) {
        return bitSet == null ? null : bitSet.toByteArray();
    }

    public static BitSet bytesToBitSet(byte[] bytes) {
        return bytes == null || bytes.length == 0
                   ? null
                   : BitSet.valueOf(bytes);
    }

}
