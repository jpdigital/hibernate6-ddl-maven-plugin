package de.jpdigital.maven.plugins.hibernate5ddl.tests.packageannotations.types;

import java.io.Serializable;
import java.util.BitSet;
import org.hibernate.SharedSessionContract;
import org.hibernate.type.descriptor.java.MutabilityPlan;

/**
 *
 * @author <a href="mailto:jens.pelzetter@googlemail.com">Jens Pelzetter</a>
 */
class BitSetMutabilityPlan implements MutabilityPlan<BitSet> {

    /**
     * Singleton access
     */
    public static final BitSetMutabilityPlan INSTANCE
        = new BitSetMutabilityPlan();

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public BitSet deepCopy(final BitSet value) {
        return BitSet.valueOf(value.toByteArray());
    }

    @Override
    public Serializable disassemble(
        final BitSet value, 
        final SharedSessionContract session
    ) {
        return value.toByteArray();
    }

    @Override
    public BitSet assemble(
        final Serializable cached, 
        final SharedSessionContract session
    ) {
        return BitSet.valueOf((byte[]) cached);
    }

}
