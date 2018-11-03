package com.shop_kiev.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberUtilTest {
    /**
     * In method assertEquals, delta tolerates the loss of accuracy
     */
    @Test
    public void calculatePercentWithRound() {
        double numberPercent = NumberUtil.calculatePercentWithRound(1, 60, 2);
        assertEquals(1.67, numberPercent, 0.0);
    }
}