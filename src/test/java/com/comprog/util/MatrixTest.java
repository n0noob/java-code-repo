package com.comprog.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    public void when4X4MatrixIsGivenInInput_thenMatrixGetsPrinted() {
        int board[][] = {
                { 0, 0, 0, 0 },
                { 0, 1, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 2, 0 }
        };
        Matrix.print(board);
    }
}