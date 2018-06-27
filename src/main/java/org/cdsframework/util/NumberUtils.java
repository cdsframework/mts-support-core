/**
 * The MTS support core project contains client related utilities, data transfer objects and remote EJB interfaces for communication with the CDS Framework Middle Tier Service.
 *
 * Copyright (C) 2016 New York City Department of Health and Mental Hygiene, Bureau of Immunization
 * Contributions by HLN Consulting, LLC
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version. You should have received a copy of the GNU Lesser
 * General Public License along with this program. If not, see <http://www.gnu.org/licenses/> for more
 * details.
 *
 * The above-named contributors (HLN Consulting, LLC) are also licensed by the New York City
 * Department of Health and Mental Hygiene, Bureau of Immunization to have (without restriction,
 * limitation, and warranty) complete irrevocable access and rights to this project.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; THE
 * SOFTWARE IS PROVIDED "AS IS" WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING,
 * BUT NOT LIMITED TO, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE COPYRIGHT HOLDERS, IF ANY, OR DEVELOPERS BE LIABLE FOR
 * ANY CLAIM, DAMAGES, OR OTHER LIABILITY OF ANY KIND, ARISING FROM, OUT OF, OR IN CONNECTION WITH
 * THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information about this software, see https://www.hln.com/services/open-source/ or send
 * correspondence to ice@hln.com.
 */
package org.cdsframework.util;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Collection of number related utility methods.
 *
 * @author HLN Consulting, LLC
 */
public class NumberUtils {

    private static final Random random = new Random();

    private synchronized static Random getRandom() {
        return random;
    }

    /**
     * Returns a random long value between 1L and 9999999999L.
     *
     * @return a random long value between 1L and 9999999999L.
     */
    public static long getRandomLong() {
        return getRandomLong(9999999999L);
    }

    /**
     * Returns a random long value between 1L and a user supplied value.
     *
     * @param range the maximum long value desired.
     * @return a random long value between 1L and a user supplied value.
     */
    public static long getRandomLong(long range) {
        return (long) (1 + (getRandom().nextDouble() * range));
    }

    /**
     * Returns a random int value between 1 and Integer.MAX_VALUE.
     *
     * @return a random int value between 1 and Integer.MAX_VALUE.
     */
    public static int getRandomInteger() {
        return (int) (1 + (getRandom().nextDouble() * Integer.MAX_VALUE));
    }

    public static Integer objectToInteger(Object object) {
        return ObjectUtils.objectToInteger(object);
    }

    public static Float objectToFloat(Object object) {
        return ObjectUtils.objectToFloat(object);
    }

    public static Double objectToDouble(Object object) {
        return ObjectUtils.objectToDouble(object);
    }

    public static Long objectToLong(Object object) {
        return ObjectUtils.objectToLong(object);
    }

    public static BigDecimal objectToBigDecimal(Object object) {
        return ObjectUtils.objectToBigDecimal(object);
    }
    
    public static boolean isDigit(String digit, boolean ignoreAsterisk) {
        boolean isDigit = true;
        for (char character : digit.toCharArray()) {
            if (ignoreAsterisk && character == '*') {
                continue;
            }
            if (!Character.isDigit(character)) {
                isDigit = false;
                break;
            }
        }
        return isDigit;
    }

}
