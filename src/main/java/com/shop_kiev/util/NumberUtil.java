package com.shop_kiev.util;

public final class NumberUtil {
    private NumberUtil() {
    }

    /**
     * Calculate percent with round.
     *
     * @param value  int value
     * @param total  int total
     * @param places int places
     * @return double percent
     */
    public static double calculatePercentWithRound(final int value, final int total, final int places) {
        return round((double) value / total * 100, places);
    }

    /**
     * The method rounds the numbers
     *
     * @param value  double value
     * @param places int places
     * @return double round
     */
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException("Places mast be positive !!!!");

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
