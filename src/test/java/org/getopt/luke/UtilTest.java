package org.getopt.luke;

import org.apache.lucene.search.similarities.DefaultSimilarity;
import org.apache.lucene.search.similarities.TFIDFSimilarity;
import org.junit.Assert;
import org.junit.Test;


public class UtilTest extends Assert {

    /* EncodeNormValue
     * for Similarity: The encoding uses a three-bit mantissa, a five-bit exponent, and the zero-exponent point at 15,
     *  thus representing values from around 7x10^9 to 2x10^-9 with about one significant decimal digit of accuracy.
     *  Zero is also represented. Negative numbers are rounded up to zero. Values too large to represent are rounded
     *  down to the largest representable value. Positive values too small to represent are rounded up to the
     *  smallest positive representable value.
     *   0xFF = 111^11111 => 157775382034845806615042743
     *   0xF0 = 111^10000
     *   0x80 = 100^00000
     *   0x00 = 000^00000 => 0 ?????
     */
    @Test
    public void EncodeNormValue_TryIt() throws Exception {
        TFIDFSimilarity sim = new DefaultSimilarity();
        // -117 == 0x8B
        assertEquals("bad byte", (byte) -117, Util.encodeNormValue(14.4123F, "fred", sim));
    }
}
