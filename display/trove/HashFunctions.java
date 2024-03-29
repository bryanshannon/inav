// Copyright (c) 1999 CERN - European Organization for Nuclear Research.

// Permission to use, copy, modify, distribute and sell this software and
// its documentation for any purpose is hereby granted without fee,
// provided that the above copyright notice appear in all copies and that
// both that copyright notice and this permission notice appear in
// supporting documentation. CERN makes no representations about the
// suitability of this software for any purpose. It is provided "as is"
// without expressed or implied warranty.

package trove;

/**
 * Provides various hash functions.
 *
 * @author wolfgang.hoschek@cern.ch
 * @version 1.0, 09/24/99
 */
public final class HashFunctions {
    /**
     * Returns a hashcode for the specified value.
     *
     * @return  a hash code value for the specified value. 
     */
    public static final int hash(double value) {
        long bits = Double.doubleToLongBits(value);
        return (int)(bits ^ (bits >>> 32));
        //return (int) Double.doubleToLongBits(value*663608941.737);
        //this avoids excessive hashCollisions in the case values are
        //of the form (1.0, 2.0, 3.0, ...)
    }

    /**
     * Returns a hashcode for the specified value.
     *
     * @return  a hash code value for the specified value. 
     */
    public static int hash(float value) {
        return Float.floatToIntBits(value*663608941.737f);
        // this avoids excessive hashCollisions in the case values are
        // of the form (1.0, 2.0, 3.0, ...)
    }

    /**
     * Returns a hashcode for the specified value.
     *
     * @return  a hash code value for the specified value.
     */
    public static int hash(int value) {
        // Multiple by prime to make sure hash can't be negative (see Knuth v3, p. 515-516)
        return value * 31;
    }

    /**
     * Returns a hashcode for the specified value. 
     *
     * @return  a hash code value for the specified value. 
     */
    public static int hash(long value) {
        // Multiple by prime to make sure hash can't be negative (see Knuth v3, p. 515-516)
        return ((int)(value ^ (value >> 32))) * 31;
    }

    /**
     * Returns a hashcode for the specified object.
     *
     * @return  a hash code value for the specified object. 
     */
    public static int hash(Object object) {
        return object==null ? 0 : object.hashCode();
    }
}
