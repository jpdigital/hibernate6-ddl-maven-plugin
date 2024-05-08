package de.jpdigital.maven.plugins.hibernate5ddl.tests.packageannotations.types;

import java.sql.Types;
import org.hibernate.type.descriptor.WrapperOptions;

import java.util.BitSet;
import org.hibernate.type.descriptor.java.AbstractClassJavaType;
import org.hibernate.type.descriptor.java.MutabilityPlan;
import org.hibernate.type.descriptor.jdbc.JdbcType;
import org.hibernate.type.descriptor.jdbc.JdbcTypeIndicators;


/**
 * Copied from the Hibernate Documentation
 */
public class BitSetJavaType extends AbstractClassJavaType<BitSet> {

    public static final BitSetJavaType INSTANCE
        = new BitSetJavaType();

    private static final long serialVersionUID = 1L;

    public BitSetJavaType() {
        super(BitSet.class);
    }

    @Override
    public MutabilityPlan<BitSet> getMutabilityPlan() {
        return BitSetMutabilityPlan.INSTANCE;
    }
    
    @Override
    public JdbcType getRecommendedJdbcType(final JdbcTypeIndicators indicators) {
        return indicators.getTypeConfiguration()
                .getJdbcTypeRegistry()
                .getDescriptor(Types.VARCHAR);
    }

    @Override
    public String toString(final BitSet value) {
        return BitSetHelper.bitSetToString(value);
//        StringBuilder builder = new StringBuilder();
//        for (long token : value.toLongArray()) {
//            if (builder.length() > 0) {
//                builder.append(DELIMITER);
//            }
//            builder.append(Long.toString(token, 2));
//        }
//        return builder.toString();
    }

      @Override
    public BitSet fromString(CharSequence string) {
        return BitSetHelper.stringToBitSet(string.toString());
    }
    
//    @Override
//    public BitSet fromString(final String string) {
//        if (string == null || string.isEmpty()) {
//            return null;
//        }
//        String[] tokens = string.split(DELIMITER);
//        long[] values = new long[tokens.length];
//
//        for (int i = 0; i < tokens.length; i++) {
//            values[i] = Long.valueOf(tokens[i], 2);
//        }
//        return BitSet.valueOf(values);
//    }

    @Override
    @SuppressWarnings("unchecked")
    public <X> X unwrap(
        final BitSet value, 
        final Class<X> type, 
        final WrapperOptions options
    ) {
        if (value == null) {
            return null;
        }
        if (BitSet.class.isAssignableFrom(type)) {
            return (X) value;
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) toString(value);
        }
        if (type.isArray()) {
            if (type.getComponentType() == byte.class) {
                return (X) value.toByteArray();
            }
        }
        throw unknownUnwrap(type);
    }

    @Override
    public <X> BitSet wrap(final X value, final WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (value instanceof CharSequence) {
            return fromString((CharSequence) value);
        }
        if (value instanceof BitSet) {
            return (BitSet) value;
        }
        throw unknownWrap(value.getClass());
    }

}
