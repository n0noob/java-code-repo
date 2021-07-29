package com.comprog.algorithm.divandconq;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindSqrtTest {

    @Test
    public void whenPerfectSquareIsGiven_thenVerifyOutput() {
        FindSqrt findSqrt = new FindSqrt();
        int res = findSqrt.mySqrt(121);
        assertEquals(11, res);
    }

    @Test
    public void whenNonPerfectSquareIsGiven_thenVerifyOutput() {
        FindSqrt findSqrt = new FindSqrt();
        int res = findSqrt.mySqrt(10);
        assertEquals(3, res);
    }

    @Test
    public void whenLargeIntegerIsGiven_thenVerifyOutput() {
        FindSqrt findSqrt = new FindSqrt();
        int res = findSqrt.mySqrt(2147483647);
        assertEquals(46340, res);
    }

}